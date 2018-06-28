package onlineStore.Products;

import onlineStore.Interfaces.Likeable;

public class TV extends Electronics implements Likeable {
    private int screenSize;
    private DisplayTechnologyType displayTechnology;
    private int modelYear;
    private int likes;

    public TV(String brand, String model,String description, double price, String image,  String color, int screenSize, DisplayTechnologyType displayTechnology, int modelYear) {
        super(description, price, image, brand, model, color);
        this.screenSize = screenSize;
        this.displayTechnology = displayTechnology;
        this.modelYear = modelYear;
        this.likes = 0;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public DisplayTechnologyType getDisplayTechnology() {
        return displayTechnology;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of %s %s",this.getBrand(),this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n",this.getModel());
        System.out.printf("Brand: %s\n",this.getBrand());
        System.out.printf("Price: %.2f\n",this.getPrice());
        System.out.printf("Color: %s\n",this.getColor());
        System.out.printf("Screen size: %s\"\n",this.getScreenSize());
        System.out.printf("Display technology: %s\n",this.getDisplayTechnology());
        System.out.printf("Model year: %d\n",this.getModelYear());
        System.out.printf("Description: %s\n",this.getDescription());
        System.out.println();

    }

    @Override
    public void addLike() {
        this.likes++;
    }
}
