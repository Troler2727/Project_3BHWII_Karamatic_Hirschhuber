package Models;

public class Message {
    public int message_id;
    public String Message;
    public String key;
    public int sender_id;
    public int reciever_id;

    public int getMessage_id() {
        return message_id;
    }

    public String getMessage() {
        return Message;
    }

    public String getKey() {
        return key;
    }

    public int getSender_id() {
        return sender_id;
    }

    public int getReciever_id() {
        return reciever_id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public void setReciever_id(int reciever_id) {
        this.reciever_id = reciever_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }
    public Message(){
        this(0, "", "",0,0);
    }
    public Message(int message_id, String message, String key, int sender_id,int reciever_id) {
        this.setMessage_id(message_id);
        this.setMessage(message);
        this.setKey(key);
        this.setSender_id(sender_id);
        this.setReciever_id(reciever_id);
    }
    @Override
    public String toString() {
        return message_id + " " + Message+ " " + key + '\n' +
                sender_id + " " + reciever_id+"";
    }
}
