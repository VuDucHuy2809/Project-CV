using Shared.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Server.Controller
{
    public class ConversationManager
    {
        public Dictionary<string, Conversation> Conversations { get; set; } = new Dictionary<string, Conversation>();
        //public List<Conversation> conversations { get; set; } = new List<Conversation>();
        public int ConversationCount() { return Conversations.Count; }
        public String Create(List<String> users)
        {
            try
            {
                var id = Guid.NewGuid().ToString();
                var conversation = new Conversation
                {
                    Members = users,
                };
                this.Conversations.Add(id, conversation);
                return id;
            }
            catch (Exception)
            {
                return null;
            }
        }

        public bool Delete(String id)
        {
            if (this.Conversations.ContainsKey(id))
            {
                this.Conversations.Remove(id);
                return true;
            }
            return false;
        }

        public bool Join(String id, String username)
        {
            if (Conversations.ContainsKey(id))
            {
                if (!Conversations[id].Members.Contains(username))
                {
                    Conversations[id].Members.Add(username);
                    return true;
                }
                return false;
            }
            return false;
        }

        public bool Leave(String id, String username)
        {
            if (Conversations.ContainsKey(id))
            {
                if (Conversations[id].Members.Contains(username))
                {
                    Conversations[id].Members.Remove(username);
                    if (Conversations[id].Members.Count == 0)
                        return Delete(id);
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}
