package onlineStore.Products;

import onlineStore.Interfaces.CreditCardPayable;
import onlineStore.Interfaces.Likeable;

public class Laptop extends Electronics implements Likeable,CreditCardPayable {
    private int displaySize;
    private int ram;
    private String cpuType;
    private int likes;

    public Laptop(String brand, String model,String description, double price, String image,  String color, int displaySize, int ram, String cpuType) {
        super(description, price, image, brand, model, color);
        this.displaySize = displaySize;
        this.ram = ram;
        this.cpuType = cpuType;
        this.likes = 0;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public int getRam() {
        return ram;
    }

    public String getCpuType() {
        return cpuType;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public void addLike() {
        this.likes++;
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of laptop %s %s.",this.getBrand(),this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n",this.getModel());
        System.out.printf("Brand: %s\n",this.getBrand());
        System.out.printf("Price: %.2f\n",this.getPrice());
        System.out.printf("Color: %s\n",this.getColor());
        System.out.printf("Display size: %s''\n",this.displaySize);
        System.out.printf("RAM: %d\n",this.getRam());
        System.out.printf("CPU type: %s\n",this.getCpuType());
        System.out.printf("Description: %s\n",this.getDescription());
        System.out.printf("Likes: %d",this.getLikes());
        System.out.println();


    }

    @Override
    public void creditCardPayable() {
        this.setPrice(this.getPrice()*0.9);
    }
}
