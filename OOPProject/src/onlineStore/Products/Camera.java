package onlineStore.Products;

public class Camera extends Electronics {
    private int opticalZoom;
    private boolean hasImageStabilization;

    public Camera(String brand, String model, String description, double price, String image, String color, int opticalZoom, boolean hasImageStabilization) {
        super(description, price, image, brand, model, color);
        this.opticalZoom = opticalZoom;
        this.hasImageStabilization = hasImageStabilization;
    }

    public int getOpticalZoom() {
        return opticalZoom;
    }

    public String hasImageStabilization() {
        return hasImageStabilization ? "Yes" : "No";
    }

    @Override
    public void showImage() {
        System.out.printf("This is the image of Camera %s %s.", this.getBrand(), this.getModel());
    }

    @Override
    public void showDescription() {
        System.out.printf("Model: %s\n", this.getModel());
        System.out.printf("Brand: %s\n", this.getBrand());
        System.out.printf("Price: %.2f\n", this.getPrice());
        System.out.printf("Color: %s\n", this.getColor());
        System.out.printf("Optical zoom: %dx\n", this.getOpticalZoom());
        System.out.printf("Image stabilization: %s\n", this.hasImageStabilization());
        System.out.printf("Description: %s\n", this.getDescription());
        System.out.println();

    }
}
