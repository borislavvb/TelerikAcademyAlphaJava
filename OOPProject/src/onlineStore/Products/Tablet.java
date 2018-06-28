package onlineStore.Products;

import onlineStore.Interfaces.ColorChangeable;
import onlineStore.Interfaces.Commentable;

import java.util.ArrayList;

public class Tablet extends Electronics implements Commentable, ColorChangeable {
    private int displaySize;
    private OperationSystemType operationSystem;
    private WirelessTechnologyType wirelessTech;
    ArrayList<String> comments;

    public Tablet(String brand, String model, String description, double price, String image,  String color, int displaySize, OperationSystemType operationSystem, WirelessTechnologyType wirelessTech) {
        super(description, price, image, brand, model, color);
        this.displaySize = displaySize;
        this.operationSystem = operationSystem;
        this.wirelessTech = wirelessTech;
        comments = new ArrayList<>();
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public OperationSystemType getOperationSystem() {
        return operationSystem;
    }

    public WirelessTechnologyType getWirelessTech() {
        return wirelessTech;
    }

    public void showComments(){
        this.comments
                .forEach(System.out::println);
    }
    @Override
    public void addComment(String comment) {
        this.comments.add(comment);
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of tablet %s %s.",this.getBrand(),this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n",this.getModel());
        System.out.printf("Brand: %s\n",this.getBrand());
        System.out.printf("Price: %.2f\n",this.getPrice());
        System.out.printf("Color: %s\n",this.getColor());
        System.out.printf("Display size: %s\"\n",this.getDisplaySize());
        System.out.printf("Operation system: %s\n",this.getOperationSystem());
        System.out.printf("Wireless technology: %s\n",this.getWirelessTech());
        System.out.printf("Description: %s\n",this.getDescription());
        System.out.println();


    }

    @Override
    public void changeColor(String color) {
        this.setColor(color);
    }
}
