package onlineStore.Products;

public class Book extends Product {
    private String title;
    private String author;
    private String publisher;

    public Book(String title,String author,String publisher,String description, double price, String image) {
        super(description, price, image);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }


    @Override
    public void showDescription() {
        System.out.printf("Title: %s\n",this.getTitle());
        System.out.printf("Author: %s\n",this.getAuthor());
        System.out.printf("Publisher: %s\n",this.getPublisher());
        System.out.printf("Price: %.2f\n",this.getPrice());
        System.out.printf("Description: %s\n",this.getDescription());
        System.out.println();
    }
}
