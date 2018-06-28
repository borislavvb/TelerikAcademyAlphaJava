package onlineStore.Products;

import onlineStore.Interfaces.CreditCardPayable;

public class MP3Player extends Electronics implements CreditCardPayable {
    private int storage;
    private int weight;

    public MP3Player(String brand, String model, String description, double price, String image, String color, int storage, int weight) {
        super(description, price, image, brand, model, color);
        this.storage = storage;
        this.weight = weight;
    }

    public int getStorage() {
        return storage;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void creditCardPayable() {
        this.setPrice(this.getPrice()*0.9);
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of MP3 player %s %s.",this.getBrand(),this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n",this.getModel());
        System.out.printf("Brand: %s\n",this.getBrand());
        System.out.printf("Price: %.2f\n",this.getPrice());
        System.out.printf("Color: %s\n",this.getColor());
        System.out.printf("Storage: %dGB\n",this.getStorage());
        System.out.printf("Weight: %d\n",this.getWeight());
        System.out.printf("Description: %s\n",this.getDescription());
        System.out.println();

    }
}
