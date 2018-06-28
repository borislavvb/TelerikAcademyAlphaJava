package onlineStore.Products;

public abstract class Product {
    private String description;
    private double price;
    private String image;

    public Product(String description, double price, String image) {
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public abstract void showDescription();
}
