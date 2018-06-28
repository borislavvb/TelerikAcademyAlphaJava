package onlineStore.Forum;

import onlineStore.Forum.Message;

public class TextMessage extends Message {
    private String content;

    public TextMessage(String author, String time, String content){
        super(author, time);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    void display(Message message) {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), content);

    }
}
