using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Shaping;
using System.Drawing.Drawing2D;
using System.Runtime.InteropServices;
using System.Reflection;
using chat.CustomEventArgs;
using System.Net.Sockets;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using System.Threading;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.TrackBar;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;
using Shared.Entity;
using System.Xml.Linq;
using chat.Properties;
using System.Threading.Tasks;

namespace chat
{
    public partial class Form1 : BeautyForm //Inherited from Beauty, which a custom form.
    {
        public TcpClient clientSocket;
        public NetworkStream stream = default(NetworkStream);
        public LoginForm loginForm;
        public Stickers stickers;
        public RegisterForm registerForm;
        public ConversationCreateForm conversationCreateForm;
        public ConversationMemberForm conversationMemberForm;
        public Menu menu;
        public String Username = null;
        Thread clientReceiveThread;
        public Dictionary<string, Conversation> Conversations = new Dictionary<string, Conversation>();
        public string currentConversationId = null;
        public enum ErrorType
        {
            server,
            exception,
            app,
        }


        public Form1()
        {
            InitializeComponent();


            loginForm = new LoginForm();
            loginForm.LoginCallback += LoginCallback;
            loginForm.RegisterRequestCallback += OnRegisterRequest;

            registerForm = new RegisterForm();
            registerForm.RegisterCallback += RegisterCallback;
            registerForm.LoginRequestCallback += OnLoginRequest;

            conversationCreateForm = new ConversationCreateForm();
            conversationCreateForm.SubmitCallback += ConversationCreateCallback;

            menu = new Menu();
            menu.ViewMemberCallback += ViewMemberConversation;
            menu.LeaveConversationCallback += LeaveConversation;

            stickers = new Stickers();
            stickers.ChoosenCallback += StickerChoosen;

            conversationMemberForm = new ConversationMemberForm();
            conversationMemberForm.AddMemberCallback += ConversationAddMemberCallback;


            clientSocket = new TcpClient();
            conversationList.Controls.Clear();
            chatZone.Controls.Clear();

            while (true)
            {
                try
                {
                    clientSocket.Connect("192.168.31.36", 5000);
                    Console.WriteLine("Đã kết nối");
                    stream = clientSocket.GetStream();

                    if (this.Username == null)
                    {
                        new Thread(this.ClientLobbyReceive).Start();
                        loginForm.ShowDialog();
                    }
                    if (this.Username != null)
                    {
                        clientReceiveThread = new Thread(this.ClientReceive);
                        clientReceiveThread.Start();
                        helloLabel.Text = $"Chào {Username}!";
                        
                    }
                    else
                    {
                        MessageBox.Show("LỖI");
                        Environment.Exit(-1);
                    }

                    break;


                }
                catch (Exception ex)
                {
                    var result = MessageBox.Show("Kết nối máy chủ thất bại", "Sự cố", MessageBoxButtons.RetryCancel, MessageBoxIcon.Question);
                    if (result == DialogResult.Retry)
                        continue;
                    Environment.Exit(-1);
                }
            }
        }

        public void sendToServer(string type, List<string> data)
        {
            try
            {
                var stream = clientSocket.GetStream();

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
                MessageBox.Show($"Gửi không thành công\nChi tiết: {ex.ToString()}", "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void ConversationAddMemberCallback(object sender, EventArgs e)
        {
            var args = e as ConversationAddMember;

            sendToServer("addMemberConversation", new List<string>
            {
                currentConversationId,
                args.Username,
            });
        }

        private void ConversationCreateCallback(object sender, EventArgs e)
        {
            var eventArgs = e as ConversationCreate;

            sendToServer("createConversation", eventArgs.Users);
        }

        private void LoginCallback(object sender, EventArgs e)
        {
            var logged = e as Logged;

            sendToServer("login", new List<string>() {
                logged.Username,
                logged.Password,
            });
        }

        private void OnRegisterRequest(object sender, EventArgs e)
        {
            loginForm.Hide();
            registerForm.ShowDialog();
        }

        private void OnLoginRequest(object sender, EventArgs e)
        {
            registerForm.Hide();
            loginForm.Show();
        }

        private void RegisterCallback(object sender, EventArgs e)
        {
            var r = e as Register;

            sendToServer("register", new List<string>() {
                r.Username,
                r.Password,
                r.CPassword,
            });
        }

        private void OnSuccess(List<string> parts)
        {
            /**
                * SUCCESS PARTS: 
                * 
                * 0: "success"
                * 1: type ["login","register",...]
                * 2,3,4,... : params
                * 
                */
            var type = parts[1];
            switch (type)
            {
                case "login":
                    OnLogged(parts);
                    break;
                case "register":
                    OnRegistered(parts);
                    break;
                case "createConversation":
                    {
                        conversationCreateForm.Invoke(new MethodInvoker(delegate ()
                        {
                            MessageBox.Show("Tạo cuộc trò chuyện thành công", "Thành công", MessageBoxButtons.OK, MessageBoxIcon.Information);
                            conversationCreateForm.Clear();
                            conversationCreateForm.Hide();
                        }));
                    }
                    break;
                default:
                    break;
            }
        }

        private void OnLogged(List<string> parts)
        {
            loginForm.Invoke(new MethodInvoker(delegate ()
            {
                registerForm.Close();
                loginForm.Close();

                Username = parts[2];
                
            }));
            
        }

        private void OnRegistered(List<string> parts)
        {
            MessageBox.Show("Đăng kí thành công", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            registerForm.Invoke(new MethodInvoker(delegate()
            {
                registerForm.Hide();
                loginForm.Show();
            }));
            
            
        }

        private bool SocketConnected(TcpClient s) //check whether client is connected server
        {
            bool flag = false;
            try
            {
                bool part1 = s.Client.Poll(10, SelectMode.SelectRead);
                bool part2 = (s.Available == 0);
                if (part1 && part2)
                {
                    flag = false;
                }
                else
                {
                    flag = true;
                }
            }
            catch (Exception er)
            {
                Console.WriteLine(er);
            }
            return flag;
        }

        private void ClientLobbyReceive()
        {
            try
            {
                while (Username == null)
                {
                    stream = clientSocket.GetStream();
                    byte[] inStream = new byte[15882925];
                    stream.Read(inStream, 0, inStream.Length);
                    List<string> parts = null;

                    if (!SocketConnected(clientSocket))
                    {
                        MessageBox.Show("You've been Disconnected");
                        clientReceiveThread.Abort();
                        clientSocket.Close();
                    }

                    parts = ByteArrayToObject(inStream) as List<string>;
                    switch (parts[0])
                    {
                        case "success":
                            OnSuccess(parts);
                            break;
                        case "error":
                            OnError(ErrorType.server, parts[1]);
                            break;
                    }
                }
            }
            catch (Exception e)
            {
                MessageBox.Show(e.ToString());
                Disconnect();
                Console.WriteLine(e);
            }
        }
        private void ClientReceive()
        {
            try
            {
                while (true)
                {
                    stream = clientSocket.GetStream();
                    byte[] inStream = new byte[15882925];
                    stream.Read(inStream, 0, inStream.Length);
                    List<string> parts = null;

                    if (!SocketConnected(clientSocket))
                    {
                        MessageBox.Show("You've been Disconnected");
                        clientReceiveThread.Abort();
                        clientSocket.Close();
                    }

                    parts = ByteArrayToObject(inStream) as List<string>;
                    switch (parts[0])
                    {
                        case "createConversation":
                            OnConversationCreate(parts);
                            break;
                        case "addMemberConversation":
                            OnConversationAddMember(parts);
                            break;
                        case "sendMessage":
                            OnMessageRecieved(parts);
                            break;
                        case "leaveConversation":
                            OnLeaveConversation(parts);
                            break;
                        case "success":
                            OnSuccess(parts);
                            break;
                        case "error":
                            OnError(ErrorType.server, parts[1]);
                            break;
                    }
                }
            }
            catch (Exception e)
            {
                MessageBox.Show(e.ToString());
                Disconnect();
                Console.WriteLine(e);
            }
        }


        private Task Disconnect()
        {
            return Task.Run(() =>
            {
                if (!SocketConnected(clientSocket))
                {
                    clientReceiveThread.Abort();
                    clientSocket.Close();
                }
            });
        }

        private void UpdateConversationList()
        {
            this.Invoke((MethodInvoker)delegate
            {
                try
                {
                    conversationList.Controls.Clear();
                    Converzation temp = null;
                    foreach (var item in Conversations)
                    {
                        var memberWithoutMe = item.Value.MemberWithout(Username);
                        var name = "";
                        Status status = Status.None;
                        Bitmap image = null;
                        if (memberWithoutMe.Count > 1)
                        {
                            name = $"{memberWithoutMe[0]},{memberWithoutMe[1]}";
                            image = Resources.twotone_groups_black_48dp;
                        }

                        else
                        {
                            name = memberWithoutMe[0];
                            image = Resources.twotone_person_black_48dp;
                        }



                        var u = new Converzation
                        {
                            Dock = DockStyle.Top,
                            Username = name,
                            UserStatus = Status.Online,
                            UserImage = image,
                            StatusMessage = item.Value.LastMessageContent,
                            Id = item.Key,
                        };

                        u.OnClick += new Converzation.Clicked(OnUserClick);

                        conversationList.Controls.Add(u);
                        if (temp == null)
                            temp = u;
                    }

                    if (currentConversationId != null && !Conversations.ContainsKey(currentConversationId))
                    {
                        if (temp != null)
                        {

                            string name = temp.Username;
                            string statusText = temp.StatusMessage;
                            string conversationId = temp.Id;
                            Image profileImage = temp.UserImage;

                            this.chatHeader1.UserTitle = name;
                            this.chatHeader1.UserStatusText = statusText;
                            this.chatHeader1.UserImage = profileImage;
                            this.currentConversationId = conversationId;


                            UpdateBubbleList();
                        }
                        else
                        {
                            this.chatHeader1.Reset();
                            this.currentConversationId = null;


                            UpdateBubbleList();
                        }
                        
                    }
                } catch (Exception ex)
                {
                    MessageBox.Show(ex.ToString());
                }
                
            });
        }

        private void OnConversationAddMember(List<string> parts)
        {
            this.Invoke((MethodInvoker)delegate
            {
                var conversationID = parts[1];
                var inviter = parts[2];
                var newMember = parts[3];


                if (Conversations.ContainsKey(conversationID))
                {
                    
                    Conversations[conversationID].Members.Add(newMember);
                    Conversations[conversationID].addMessage(inviter, $"{inviter} đã mời {newMember} vào cuộc trò chuyện");
                    if (currentConversationId == conversationID && Username == inviter)
                        conversationMemberForm.Update(Conversations[conversationID].Members);
                }
                else
                {
                    var members = parts.GetRange(3, parts.Count - 3);
                    var conversation = new Conversation
                    {
                        Members = members,
                    };
                    conversation.addMessage(inviter, $"{inviter} đã mời bạn vào cuộc trò chuyện");
                    Conversations.Add(conversationID, conversation);
                }


                

               

                UpdateConversationList();
            });
        }

        private void OnConversationCreate(List<string> parts)
        {
            this.Invoke((MethodInvoker)delegate
            {
                var conversationID = parts[1];
                var creator = parts[2];
                var users = parts.GetRange(3, parts.Count - 3);


                var conversation = new Conversation
                {
                    Members = users,
                };
                conversation.addMessage(creator, $"{creator} đã tạo cuộc trò chuyện");

                Conversations.Add(conversationID, conversation);

                UpdateConversationList();
            });
        }
        //Move Form with the mouse. This method is available in BeautyForm that this form inherits
        protected override void OnMouseDownMoveForm(object sender, MouseEventArgs e)
        {
            base.OnMouseDownMoveForm(sender, e);
        }


    

        private void typingBox1_OnHitEnter(object sender, EventArgs e)
        {

            if (typingBox1.Value.Trim().Length == 0)
            {
                MessageBox.Show("Vui lòng nhập tin nhắn trước khi gửi");
                return;
            }
                
            if (currentConversationId == null)
            {
                MessageBox.Show("Vui lòng chọn cuộc trò chuyện trước khi gửi");
                return;
            }


            sendToServer("sendMessage", new List<string>
            {
                currentConversationId,
                "text",
                typingBox1.Value
            });

            

            typingBox1.Value = "";
        }

        private void UpdateBubbleList()
        {
            this.Invoke((MethodInvoker)delegate
            {
                List<UserControl> userControls = new List<UserControl>();
                chatZone.Controls.Clear();
                if (currentConversationId != null)
                {
                    foreach (var message in Conversations[currentConversationId].Messages)
                    {
                        UserControl bubble;
                        if (message.Owner == Username)
                        {
                            switch (message.Type)
                            {
                                case Conversation.Message.MsgType.sticker:
                                    bubble = new MeBubbleImage
                                    {
                                        Dock = DockStyle.Bottom,
                                        Body = Resources.ResourceManager.GetObject($"ami_{message.Msg}") as Bitmap
                                    };
                                    bubble.SendToBack();
                                    userControls.Add(bubble);
                                    break;
                                case Conversation.Message.MsgType.text:
                                    bubble = new MeBubble
                                    {
                                        Dock = DockStyle.Bottom,
                                        Body = message.Msg
                                    };
                                    bubble.SendToBack();
                                    userControls.Add(bubble);
                                    break;
                                case Conversation.Message.MsgType.file:
                                    bubble = new MeBubble
                                    {
                                        Dock = DockStyle.Bottom,
                                        Body = $"[{message.FileName}]",
                                    };
                                    bubble.SendToBack();
                                    userControls.Add(bubble);
                                    //
                                    break;
                                case Conversation.Message.MsgType.image:
                                    var pic = Convert.FromBase64String(message.Msg);
                                    using (MemoryStream ms = new MemoryStream(pic))
                                    {
                                        bubble = new MeBubbleImage
                                        {
                                            Dock = DockStyle.Bottom,
                                            Body = Image.FromStream(ms),
                                        };
                                        bubble.SendToBack();
                                        userControls.Add(bubble);
                                    }


                                    break;
                                default:
                                    //
                                    break;
                            }


                        }
                        else
                        {
                            switch (message.Type)
                            {
                                case Conversation.Message.MsgType.sticker:
                                    bubble = new YouBubbleImage
                                    {
                                        Creator = message.Owner,
                                        Dock = DockStyle.Bottom,
                                        Body = Resources.ResourceManager.GetObject($"ami_{message.Msg}") as Bitmap
                            };
                                    bubble.SendToBack();
                                    userControls.Add(bubble);
                                    break;
                                case Conversation.Message.MsgType.text:
                                    bubble = new YouBubble
                                    {
                                        Creator = message.Owner,
                                        Dock = DockStyle.Bottom,
                                        Body = message.Msg
                                    };
                                    bubble.SendToBack();
                                    userControls.Add(bubble);
                                    break;
                                case Conversation.Message.MsgType.file:
                                    var bubbleFile = new YouBubble
                                    {
                                        Creator = message.Owner,
                                        Dock = DockStyle.Bottom,
                                        File = Convert.FromBase64String(message.Msg),
                                        FileType = message.FileType,
                                        Body = $"[{message.FileName}] nhấp vào để tải xuống"
                                    };


                                    bubbleFile.OnChatTextClick += youBubble_OnChatTextClick;
                                    bubbleFile.SendToBack();
                                    userControls.Add(bubbleFile);

                                    break;
                                case Conversation.Message.MsgType.image:
                                    var pic = Convert.FromBase64String(message.Msg);
                                    using (MemoryStream ms = new MemoryStream(pic))
                                    {
                                        bubble = new YouBubbleImage
                                        {
                                            Creator = message.Owner,
                                            Dock = DockStyle.Bottom,
                                            Body = Image.FromStream(ms),
                                        };
                                        bubble.SendToBack();
                                        userControls.Add(bubble);
                                    }


                                    break;
                                default:
                                    //
                                    break;
                            }

                        }

                    }
                    chatZone.Controls.AddRange(userControls.ToArray());
                }
                    
                
                
            });
        }

        private void OnLeaveConversation(List<string> parts)
        {
            this.Invoke((MethodInvoker)delegate
            {
                try
                {
                    var id = parts[1];
                    var leftUser = parts[2];

                    if (Conversations.ContainsKey(id))
                    {
                        
                        if (string.IsNullOrEmpty(leftUser))
                        {
                            Conversations.Remove(id);
                            UpdateConversationList();
                        }
                        else
                        {
                            if (Conversations[id].Members.Contains(leftUser))
                            {
                                if (Username == leftUser)
                                {
                                    Conversations.Remove(id);
                                    UpdateConversationList();
                                }
                                else
                                {
                                    Conversations[id].Members.Remove(leftUser);
                                    Conversations[id].addMessage(leftUser, $"{leftUser} đã rời khỏi cuộc trò chuyện");
                                    if (currentConversationId == id)
                                        UpdateBubbleList();
                                    UpdateConversationList();
                                }
                                
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.ToString());
                }

            });
        }

        private void OnMessageRecieved(List<string> parts)
        {
            this.Invoke((MethodInvoker)delegate
            {
                try {
                    var id = parts[1];
                    var sender = parts[2];
                    var type = parts[3];
                    var message = parts[4];
                    switch (type)
                    {
                        case "text":
                            Conversations[id].addMessage(sender, message);
                            break;
                        case "image":
                            Conversations[id].addImage(sender, message);                   
                            break;
                        case "sticker":
                            Conversations[id].addSticker(sender, message);
                            break;
                        case "file":
                            if (parts.Count > 4)
                            {
                                Conversations[id].addFile(sender, message, parts[5], parts[6]);
                            }
                            break;
                        default:
                            break;
                    }
                    
                    
                    if (currentConversationId == id)
                        UpdateBubbleList();

                    UpdateConversationList();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.ToString());
                }
                
            });
            
        }
        
        private async void label1_Click(object sender, EventArgs e)
        {
            await this.Disconnect();
            Environment.Exit(0);
        }

        private void label2_Click(object sender, EventArgs e)
        {
            this.WindowState = FormWindowState.Minimized;
        }

        private void OnUserClick(object sender, EventArgs e)
        {
            var ClickedUser = sender as Converzation;

            string name = ClickedUser.Username;
            string statusText = ClickedUser.StatusMessage;
            string conversationId = ClickedUser.Id;
            Image profileImage = ClickedUser.UserImage;

            this.chatHeader1.UserTitle = name;
            this.chatHeader1.UserStatusText = statusText;
            this.chatHeader1.UserImage = profileImage;
            this.currentConversationId = conversationId;

            chatZone.Controls.Clear();

            UpdateBubbleList();
        }

        private void users1_Load(object sender, EventArgs e)
        {

        }

        private void meBubble2_Load(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
           
        }

        

        public byte[] ObjectToByteArray(object _Object)
        {
            using (var stream = new MemoryStream())
            {
                var formatter = new BinaryFormatter();
                formatter.Serialize(stream, _Object);
                return stream.ToArray();
            }
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

        private void dubugPack(List<string> packs )
        {
            var str = "Dữ liệu: \n";

            foreach (var item in packs)
            {
                str += $"+ {item} \n";
            }

            MessageBox.Show(str);
        }

        private void showConversationCreateForm_Click(object sender, EventArgs e)
        {
            conversationCreateForm.ShowDialog();
        }

        private void LeaveConversation(object sender, EventArgs e)
        {
            sendToServer("leaveConversation", new List<string>()
            {
                currentConversationId,
            });
            menu.Hide();
        }

        

        private void ViewMemberConversation(object sender, EventArgs e)
        {
            menu.Hide();
            conversationMemberForm.Show(Conversations[currentConversationId].Members);

        }

        private void Menu_Click(object sender, EventArgs e)
        {
            
            
        }

        private void OnError(ErrorType errorType, string content)
        {
            string title;
            switch (errorType)
            {
                case ErrorType.server:
                    title = "Lỗi phía máy chủ";
                    break;
                case ErrorType.exception:
                    title = "Lỗi ứng dụng";
                    break;
                case ErrorType.app:
                    title = "Lỗi thao tác";
                    break;
                default:
                    title = "Lỗi không xác định";
                    break;
            }
            MessageBox.Show(content,title,MessageBoxButtons.OK,MessageBoxIcon.Error);
        }

        private void chatHeader1_OnMenuDotClick(object sender, EventArgs e)
        {
            if (currentConversationId == null) return;
            try
            {
                menu.Show(Cursor.Position);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private void typingBox1_OnAttachmentClicked(object sender, EventArgs e)
        {
            if (currentConversationId == null) return;
          
            OpenFileDialog openFileDialog1 = new OpenFileDialog();
            DialogResult result = openFileDialog1.ShowDialog(); // Show the dialog.
            if (result == DialogResult.OK) // Test result.
            {
                string file = openFileDialog1.FileName;
                var filename = openFileDialog1.SafeFileName;
                string extension = Path.GetExtension(file);
                string type = "";
                switch (extension)
                {
                    case ".jpg":
                    case ".png":
                    case ".jpeg":
                        type = "image";
                        break;
                    default:
                        type = "file";
                        break;
                }
                
                Console.WriteLine(file);
                try
                {
                    string base64 = Convert.ToBase64String(File.ReadAllBytes(file));
                    var parts = new List<string>()
                    {
                        currentConversationId,
                        type,
                        base64,
                    };

                    if (type == "file")
                    {
                        parts.Add(extension);
                        parts.Add(filename);
                    }
                    
                    byte[] bytes = ObjectToByteArray(parts);
                    if (bytes.LongLength > 15882925)
                        MessageBox.Show("Tệp tin quá lớn");
                    else
                    {
                        sendToServer("sendMessage", parts);
                    }
                    
                   
                }
                catch (IOException ex)
                {
                    MessageBox.Show(ex.ToString());
                }
            }
            
        }

        private void youBubble_OnChatTextClick(object sender, EventArgs e)
        {
            var bubble = sender as YouBubble;


            if (bubble.File != null)
            {
                SaveFileDialog saveFileDialog = new SaveFileDialog();
                saveFileDialog.Title = "Lưu tệp tin";
                saveFileDialog.FileName = DateTime.Now.ToString("yyyyMMddTHHmmss") + bubble.FileType;
                saveFileDialog.Filter = $"Tệp {bubble.FileType} (*{bubble.FileType})|*{bubble.FileType}|Tất cả loại tệp (*.*)|*.*";
                saveFileDialog.DefaultExt = bubble.FileType;
                
                
                DialogResult dialogResult = saveFileDialog.ShowDialog();
                if (dialogResult == DialogResult.OK)
                {
                    if (String.IsNullOrEmpty(saveFileDialog.FileName))
                    {
                        MessageBox.Show("Đường dẫn lưu file trống");
                    }
                    string path = saveFileDialog.FileName;
                    FileInfo fi = new FileInfo(path);

                    // Open the stream for writing.
                    using (FileStream fs = fi.OpenWrite())
                    {
                        byte[] info = bubble.File;

                        // Add some information to the file.
                        fs.Write(info, 0, info.Length);
                    }


                }
                else
                {
                    //Inform the user
                }
            }
        }

        private void typingBox1_OnEmojiClicked(object sender, EventArgs e)
        {
            if (currentConversationId == null) return;
            try
            {
                stickers.Show(Cursor.Position);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
            

        }

        private void StickerChoosen(object sender, EventArgs e)
        {
            if (e is StickerArgs sticker)
            {
                sendToServer("sendMessage", new List<string>()
                {
                    currentConversationId,
                    "sticker",
                    sticker.Id,
                });
            }
        }
    }
}
