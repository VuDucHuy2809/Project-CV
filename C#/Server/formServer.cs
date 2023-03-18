using Server.Controller;
using Shared.Entity;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Serialization;
using static Server.Server;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace Server
{
    public partial class Server : Form
    {
        public class User
        {
            public bool Send(byte[] bytes)
            {
                try
                {
                    var stream = Client.GetStream();
                    stream.Write(bytes, 0, bytes.Length);
                    stream.Flush();
                    return true;
                } catch (Exception) {
                    return false;
                }
                
            }
            public string Username { get; set; }
            public TcpClient Client;
            public Thread Thread;
            public string Password { get; set; }
            public bool Online()
            {
                if (Thread == null)
                    return false;
                return Thread.IsAlive;
            }        
            public void Disconnect()
            {
                if (Client != null)
                    Client.Close();
                if (Thread != null)
                    Thread.Abort();


                Client = null;
                Thread = null;
            }
        }
        TcpListener listener = new TcpListener(IPAddress.Any, 5000);
        TcpClient client;
        String clNo;
        Dictionary<string, User> users = new Dictionary<string, User>();
        //Dictionary<string, TcpClient> clientList = new Dictionary<string, TcpClient>();
        //Dictionary<string, Thread> threadList = new Dictionary<string, Thread>();
        ConversationManager ConversationManager = new ConversationManager();
        CancellationTokenSource cancellation = new CancellationTokenSource();
        List<string> chat = new List<string>();
        bool TcpState = false;
        bool WillRestart = false;

        private void StopTcp()
        {
            if (TcpState)
            {
                listener.Stop();
                TcpState = false;
            }
            
        }

        private void StartTcp()
        {
            if (!TcpState)
            {
                listener.Start();
                TcpState = true;
            }
        }

        public Server()
        {
            InitializeComponent();
        }

        private void btnStart_Click(object sender, EventArgs e)
        {
            
            startServer();
        }

        public void lobbyLogUI(String m)
        {
            this.Invoke((MethodInvoker)delegate // To Write the Received data
            {
                lobbyLog.AppendText(">> [ĐẠI SẢNH] " + m + Environment.NewLine);
            });
        }

        public void threadLogUI(String m, string flag)
        {
            this.Invoke((MethodInvoker)delegate // To Write the Received data
            {
                clientLog.AppendText($">> [{flag}]" + m + Environment.NewLine);
            });
        }

        public async void startServer()
        {
            cancellation = new CancellationTokenSource();
            StartTcp();
            lobbyLogUI("[HỆ THỐNG] Máy chủ bắt đầu: " + listener.LocalEndpoint);
            lobbyLogUI("[HỆ THỐNG] Đại sảnh sẵn sàng kết nối");
            try
            {
                while (true)
                {
                    using (cancellation.Token.Register(() => Stop()  ))
                    {
                        try
                        {
                            var client = await listener.AcceptTcpClientAsync();
                            lobbyLogUI($"[{client.Client.RemoteEndPoint}] đã kết nối");
                            byte[] data = new byte[15882925];
                            bool guest = true;
                            while (guest)
                            {
                                try
                                {
                                    NetworkStream stream = client.GetStream(); //Gets The Stream of The Connection
                                    stream.Read(data, 0, data.Length); //Receives Data 
                                    var parts = ByteArrayToObject(data) as List<string>;

                                    switch (parts[0]) {
                                        case "login":
                                            {

                                                var username = parts[1];
                                                var password = parts[2];
                                                lobbyLogUI($"{username} yêu cầu đăng nhập");

                                                if (users.ContainsKey(username) && users[username].Password == password)
                                                {
                                                    var user = users[username];
                                                    user.Client = client;
                                                    user.Thread = new Thread(() => ServerReceive(client, username));
                                                    user.Thread.Start();
                                                    
                                                    sendToClient(client, "success", new List<string>
                                                    {
                                                        "login",
                                                        username
                                                    });
                                                    guest = false;
                                                    online.Items.Add(username);
                                                    lobbyLogUI($"{username} đã đăng nhập thành công");
                                                }
                                                else
                                                {
                                                    sendToClient(client, "error", new List<string>
                                                    {
                                                        "Tên người dùng hoặc mật khẩu không đúng"
                                                    });
                                                }    
                                            } 
                                            break;
                                        case "register":
                                            {
                                                var username = parts[1];
                                                var password = parts[2];
                                                var cPassword = parts[3];
                                                if (password == cPassword)
                                                {
                                                    try
                                                    {
                                                        users.Add(username, new User
                                                        {
                                                            Username = username,
                                                            Password = password,
                                                        });
                                                        listBox1.Items.Add(username);
                                                        sendToClient(client, "success", new List<string>
                                                        {
                                                               "register",
                                                               username,
                                                        });
                                                        lobbyLogUI($"{username} đã đăng kí thành công");
                                                    }
                                                    catch (Exception ex)
                                                    {
                                                        //USER IS ALREADY
                                                        if (ex is ArgumentException)
                                                            sendToClient(client, "error", new List<string>
                                                            {
                                                                "Tên người dùng đã tồn tại"
                                                            });

                                                    }
                                                }
                                                else
                                                {
                                                    //PASSWORD NOT MATCH
                                                    sendToClient(client, "error", new List<string>
                                                    {
                                                        "Mật khẩu không trùng khớp"
                                                    });
                                                }
                                            }
                                            
                                            break;
                                        default:
                                        break;
                                    }

                                }
                                catch (Exception ex)
                                {
                                    if (ex.GetType() == typeof(IOException))
                                        lobbyLogUI($"[{client.Client.RemoteEndPoint}] đã ngắt kết nối");
                                    else
                                        MessageBox.Show(ex.ToString());
                                    break;
                                }
                            }
                        }
                        catch (InvalidOperationException)
                        {
                            // Either tcpListener.Start wasn't called (a bug!)
                            // or the CancellationToken was cancelled before
                            // we started accepting (giving an InvalidOperationException),
                            // or the CancellationToken was cancelled after
                            // we started accepting (giving an ObjectDisposedException).
                            //
                            // In the latter two cases we should surface the cancellation
                            // exception, or otherwise rethrow the original exception.
                            cancellation.Token.ThrowIfCancellationRequested();
                            throw;
                        }
                    }

                }
            }
            catch (Exception ex)
            {
                if (ex is System.OperationCanceledException)
                {
                    lobbyLogUI("Đại sảnh đã dừng chờ");
                    if (WillRestart)
                    {
                        startServer();
                        WillRestart = false;
                    }
                }
                else if (ex is System.ObjectDisposedException)
                {
                    lobbyLogUI("Đại sảnh đã dừng" + ex.ToString());
                }
                else
                {
                    lobbyLogUI("Xảy ra lỗi, chi tiết: \n" + ex.ToString());
                    lobbyLogUI("Máy chủ ngưng kết nối. \"Khởi động máy chủ\" để khởi động lại");
                }
                    
                
            }

        }

        public void announce(string username, string state)
        {
            sendToAll("announce", new List<string>
            {
                username,
                state,
            });
        }

        public void sendToAll(string type, List<string> data)
        {
            foreach (var user in users)
            {
                var pack = new List<string>
                    {
                        type,
                    };

                pack.AddRange(data);

                byte[] bytes = ObjectToByteArray(pack);
                user.Value.Send(bytes);
            }
        }

        public void sendToUsers(List<string> users, string type, List<string> data)
        {
            foreach (var user in users)
            {

                var pack = new List<string>
                    {
                        type,
                    };

                pack.AddRange(data);

                byte[] bytes = ObjectToByteArray(pack);
                this.users[user].Send(bytes);
            }
        }

        public void sendToClient(TcpClient client, string type, List<string> data)
        {
            try
            {
                var stream = client.GetStream();

                var pack = new List<string>
                {
                    type,
                };

                pack.AddRange(data);

                byte[] bytes = ObjectToByteArray(pack);

                stream.Write(bytes, 0, bytes.Length);
                stream.Flush();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        public void sendToUser(string username, string type, List<string> data)
        {
            var pack = new List<string>
            {
                type,
            };

            pack.AddRange(data);

            byte[] bytes = ObjectToByteArray(pack);
            this.users[username].Send(bytes);
        }

        public void sendError(string username, string message)
        {
            var pack = new List<string>
            {
                "error",
                message,
            };

            byte[] bytes = ObjectToByteArray(pack);
            this.users[username].Send(bytes);
        }

        public void sendSuccess(string username, string type)
        {
            var pack = new List<string>
            {
                "success",
                type,
            };

            byte[] bytes = ObjectToByteArray(pack);
            this.users[username].Send(bytes);
        }

        public void sendSuccess(string username, List<string> message)
        {
            var pack = new List<string>
            {
                "success",
            };

            pack.AddRange(message);

            byte[] bytes = ObjectToByteArray(pack);
            this.users[username].Send(bytes);
        }


        public Object ByteArrayToObject(byte[] arrBytes)
        {
            using (var memStream = new MemoryStream())
            {
                var binForm = new BinaryFormatter();
                memStream.Write(arrBytes, 0, arrBytes.Length);
                memStream.Seek(0, SeekOrigin.Begin);
                var obj = binForm.Deserialize(memStream);
                return obj;
            }
        }

        public byte[] ObjectToByteArray(Object obj)
        {
            BinaryFormatter bf = new BinaryFormatter();
            using (var ms = new MemoryStream())
            {
                bf.Serialize(ms, obj);
                return ms.ToArray();
            }
        }



        public void ServerReceive(TcpClient clientn, String username)
        {
            //USER ONLINE
            announce(username, "online");
            threadLogUI($"Đã từ [ĐẠI SẢNH] qua đây", username);
            byte[] data = new byte[15882925];
            while (true)
            {
                try
                {
                    NetworkStream stream = clientn.GetStream(); //Gets The Stream of The Connection
                    stream.Read(data, 0, data.Length); //Receives Data 
                    var parts = ByteArrayToObject(data) as List<string>;

                    switch (parts[0])
                    {
                        case "leaveConversation":
                            if (ConversationManager.Conversations.ContainsKey(parts[1])
                                && ConversationManager.Conversations[parts[1]].Members.Contains(username))
                            {
                                
                                if (ConversationManager.Conversations[parts[1]].Members.Count < 3)
                                {
                                    
                                    sendToUsers(ConversationManager.Conversations[parts[1]].Members, "leaveConversation", new List<string>
                                    {
                                        parts[1],
                                        null,
                                    });
                                    ConversationManager.Conversations.Remove(parts[1]);
                                    threadLogUI($"Đã rời khỏi và xóa ({parts[1]}) vì chỉ còn 1 người trong cuộc trò chuyện", username);
                                }
                                else
                                {
                                    sendToUsers(ConversationManager.Conversations[parts[1]].Members, "leaveConversation", new List<string>
                                    {
                                        parts[1],
                                        username,
                                    });
                                    ConversationManager.Leave(parts[1], username);
                                    threadLogUI($"Đã rời khỏi ({parts[1]})", username);
                                }
                                    
                                
                            }
                            break;
                        case "sendMessage":
                            {
                                var conversationID = parts[1];
                                var type = parts[2];
                                var message = parts[3];

                                if (!ConversationManager.Conversations.ContainsKey(conversationID))
                                {
                                    sendToUser(username, "error", new List<string>
                                    {
                                        "Cuộc trò chuyện không tồn tại"
                                    });
                                }
                                else
                                {
                                    var conversation = ConversationManager.Conversations[conversationID];

                                    if (parts.Count > 4)
                                    {
                                        sendToUsers(conversation.Members, "sendMessage", new List<string>
                                        {
                                            conversationID,
                                            username,
                                            type,
                                            message,
                                            parts[4],
                                            parts[5],
                                        });
                                    }
                                    else
                                    {
                                        sendToUsers(conversation.Members, "sendMessage", new List<string>
                                        {
                                            conversationID,
                                            username,
                                            type,
                                            message,
                                        });
                                    }
                                    threadLogUI($"Đã gửi 1 {((type == "text") ? "tin nhắn" : "tệp tin")} trong ({conversationID})", username);
                                }
                            } 
                            break;
                        case "createConversation":
                            {
                                var us = parts.GetRange(1, parts.Count - 1);
                                var notFound = new List<string>();
                                foreach (var item in us)
                                {
                                    if (!users.ContainsKey(item))
                                    {
                                        notFound.Add($"Không tìm thấy người dùng: {item}");
                                    }
                                    if (username == item)
                                        notFound.Add($"Không thể thêm chính mình vào cuộc trò chuyện");
                                }
                                if (!notFound.Any())
                                {
                                    us.Insert(0, username);

                                    var id = ConversationManager.Create(us);
                                    if (id != null)
                                    {
                                        this.Invoke((MethodInvoker)delegate
                                        {
                                            conversationListBox.Items.Add(id);
                                        });

                                        var createConversation = new List<string>
                                        {
                                            id,
                                            username,
                                        };
                                        createConversation.AddRange(us);
                                        sendToUser(username, "success", new List<string>
                                        {
                                            "createConversation"
                                        });

                                        sendToUsers(us, "createConversation", createConversation);

                                        threadLogUI($"Đã tạo cuộc trò chuyện ({id})", username);
                                    }
                                }
                                else
                                {
                                    sendToUser(username, "error", notFound);
                                }
                            } 
                            break;
                        case "addMemberConversation":
                            {
                                var conversationID = parts[1];
                                var newMember = parts[2];
                                if (!ConversationManager.Conversations.ContainsKey(conversationID))
                                {
                                    sendError(username,
                                        "Cuộc trò chuyện không tồn tại");
                                }
                                else if (ConversationManager.Conversations[conversationID].Members.Contains(newMember))
                                {
                                    sendError(username,
                                        $"Thêm thất bại, {newMember} là thành viên của cuộc trò chuyện này");
                                }
                                else if (!users.ContainsKey(newMember))
                                {
                                    sendError(username,
                                        $"Thêm thất bại, {newMember} không tồn tại");
                                }
                                else
                                {
                                    ConversationManager.Conversations[conversationID].Members.Add(newMember);
                                    var member = ConversationManager.Conversations[conversationID].MemberWithout(newMember);
                                    var send = new List<string>
                                    {
                                        conversationID,
                                        username,
                                        newMember,
                                    };
                                    send.AddRange(member);
                                    sendToUsers(ConversationManager.Conversations[conversationID].Members,
                                        "addMemberConversation",
                                        send);
                                }
                            }
                            break;
                        default:
                            {
                                sendError(username,  "Gói tin không hợp lệ ");
                            }
                            break;
                    }

                    parts.Clear();
                }
                catch (Exception r)
                {
                    threadLogUI("Đã ngắt kết nối", username);
                  //  threadLogUI(r.ToString(),username);
                    this.Invoke((MethodInvoker)delegate
                    {
                        online.Items.Remove(username);
                    });
                    announce(username, "offline");
                    users[username].Disconnect();

                   
                    break;
                }
            }
        }

        private void Start()
        {

        }

        private void Stop()
        {
            
            ConversationManager.Conversations.Clear();
            conversationListBox.Items.Clear();
            listBox1.Items.Clear();
            StopTcp();
            foreach (var Item in users)
            {
                Item.Value.Disconnect();
            }
            lobbyLogUI("[HỆ THỐNG] Đã dừng lại");
           
        }

        private void btnServerStop_Click(object sender, EventArgs e)
        {
            try
            {
                cancellation.Cancel();
                //Stop();
            }
            catch (SocketException er)
            {
                lobbyLogUI("[Stopping]: " + er.ToString());
            } 


        }



        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            lobbyLog.SelectionStart = lobbyLog.TextLength;
            lobbyLog.ScrollToCaret();
        }

        private void btnViewMember_Click(object sender, EventArgs e)
        {
            if (conversationListBox.SelectedIndex < 0)
                return;
            var members = ConversationManager.Conversations[conversationListBox.SelectedItem.ToString()].Members;

            var str = "Thành viên: \n";

            foreach (var item in members)
            {
                str += $"+ {item}\n";
            }

            MessageBox.Show(str);
        }

        private void reset_Click(object sender, EventArgs e)
        {
            WillRestart = true;
            cancellation.Cancel();
        }

        private void clearLog_Click(object sender, EventArgs e)
        {
            lobbyLog.Clear();
            clientLog.Clear();
        }
    }
}
