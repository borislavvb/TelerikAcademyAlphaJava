package onlineStore.Forum;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private List<Message> messages;

    public Forum(){
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void postText(String author, String time, String content){
        messages.add(new TextMessage(author, time, content));
    }

    public void postImage(String author, String time, String image){
        messages.add(new ImageMessage(author, time, image));
    }
}
