package onlineStore.Forum;

public abstract class Message {
    private String author;
    private String time;

    public Message(String author, String time){
        this.author = author;
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s:", time, author);
    }


    abstract void display(Message message);
}
