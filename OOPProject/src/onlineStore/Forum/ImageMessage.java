package onlineStore.Forum;

public class ImageMessage extends Message{
    private String image;
    public ImageMessage(String author, String time, String image){
        super(author, time);
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    @Override
    void display(Message message) {
        System.out.println(this);
    }
}
