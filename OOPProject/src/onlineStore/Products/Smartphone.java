package onlineStore.Products;

import onlineStore.Interfaces.ColorChangeable;
import onlineStore.Interfaces.Commentable;

import java.util.ArrayList;

public class Smartphone extends Electronics implements Commentable, ColorChangeable {
    private int cameraResolution;
    private int simSlots;
    private ArrayList<String> comments;

    public Smartphone(String brand, String model, String description, double price, String image, String color, int cameraResolution, int simSlots) {
        super(description, price, image, brand, model, color);
        this.cameraResolution = cameraResolution;
        this.simSlots = simSlots;
        this.comments = new ArrayList<>();
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public int getSimSlots() {
        return simSlots;
    }


    public void showComments() {
        this.comments
                .forEach(System.out::println);
    }

    @Override
    public void addComment(String comment) {
        this.comments.add(comment);
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of %s %s.", this.getBrand(), this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n", this.getModel());
        System.out.printf("Brand: %s\n", this.getBrand());
        System.out.printf("Price: %.2f\n", this.getPrice());
        System.out.printf("Color: %s\n", this.getColor());
        System.out.printf("Camera resolution: %sMP\n", this.cameraResolution);
        System.out.printf("Sim slots: %d\n", this.getSimSlots());
        System.out.printf("Description: %s\n", this.getDescription());
        System.out.println();
    }

    @Override
    public void changeColor(String color) {
        this.setColor(color);
    }
}
