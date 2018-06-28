package onlineStore.Products;

import onlineStore.Interfaces.CreditCardPayable;

public class Printer extends Electronics implements CreditCardPayable {
    private String connectivity;
    private int printingSpeed;

    public Printer(String brand, String model,String description, double price, String image,  String color, String connectivity,int printingSpeed) {
        super(description, price, image, brand, model, color);
        this.connectivity = connectivity;
        this.printingSpeed = printingSpeed;
    }

   public String getConnectivity() {
       return connectivity;
   }

    public int getPrintingSpeed() {
        return printingSpeed;
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of printer %s %s.",this.getBrand(),this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n",this.getModel());
        System.out.printf("Brand: %s\n",this.getBrand());
        System.out.printf("Price: %.2f\n",this.getPrice());
        System.out.printf("Color: %s\n",this.getColor());
        System.out.printf("Connectivity: %s\n",this.getConnectivity());
        System.out.printf("Printing speed: %d\n",this.getPrintingSpeed());
        System.out.printf("Description: %s\n",this.getDescription());
        System.out.println();

    }

    @Override
    public void creditCardPayable() {
        this.setPrice(this.getPrice()*0.9);
    }
}
