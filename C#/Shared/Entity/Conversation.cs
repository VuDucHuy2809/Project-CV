using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using static Shared.Entity.Conversation.Message;

namespace Shared.Entity
{
    public class Conversation
    {
        public class Member
        {
            public enum Status
            {
                Online,
                Offline,
                Unknown,
            }
            public string Username { get; set; }
            public Member.Status UserStatus { get; set; }
        }
        public class Message
        {
            public enum MsgType
            {
                text,
                file,
                image,
                sticker,
            }
            public string Owner { get; set; }
            public string Msg { get; set; }
            public MsgType Type { get; set; } = MsgType.text;
            public string FileType { get; set; }
            public string FileName { get; set; }
        }
        public List<string> Members { get; set; }
        public List<Message> Messages { get; private set; } = new List<Message>();
        
        public string LastMessageCreator { get; private set; }
        public string LastMessageContent { get; private set; }

        public void addMessage(string creator, string content)
        {
            Messages.Add(new Message
            {
                Owner = creator,
                Msg = content,
            });
            this.LastMessageContent = content;
            this.LastMessageCreator = creator;
        }

        public void addFile(string creator, string content, string fileType, string fileName)
        {
            Messages.Add(new Message
            {
                Owner = creator,
                Type = MsgType.file,
                Msg = content,
                FileType = fileType,
                FileName = fileName,
            });
            this.LastMessageContent = "đã gửi 1 tệp";
            this.LastMessageCreator = creator;
        }

        public void addImage(string creator, string content)
        {
            Messages.Add(new Message
            {
                Owner = creator,
                Type = MsgType.image,
                Msg = content,
            });
            this.LastMessageContent = "đã gửi 1 ảnh";
            this.LastMessageCreator = creator;
        }

        public void addSticker(string creator, string content)
        {
            Messages.Add(new Message
            {
                Owner = creator,
                Type = MsgType.sticker,
                Msg = content,
            });
            this.LastMessageContent = "đã gửi 1 nhãn dán";
            this.LastMessageCreator = creator;
        }

        //public void addMessage(string creator, string content, MsgType type)
        //{
        //    Messages.Add(new Message
        //    {
        //        Owner = creator,
        //        Type = type,
        //        Msg = content,
        //    });
        //    switch (type)
        //    {
        //        case MsgType.text:
        //            this.LastMessageContent = content;
        //            break;
        //        case MsgType.file:
        //            this.LastMessageContent = "đã gửi 1 tệp tin";
        //            break;
        //        case MsgType.image:
        //            this.LastMessageContent = "đã gửi 1 ảnh";
        //            break;
        //        default:
        //            this.LastMessageContent = "đã gửi gì đó";
        //            break;
        //    }

        //    this.LastMessageCreator = creator;
        //}

        public List<string> MemberWithout(string username)
        {
            return Members.Except(new string[]
            {
                username,
            }).ToList();
        }
    }
}
