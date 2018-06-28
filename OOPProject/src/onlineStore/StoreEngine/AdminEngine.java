package onlineStore.StoreEngine;

import onlineStore.Products.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminEngine {


    static ArrayList<Product> allProducts = new ArrayList<>();

    public AdminEngine() {

    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public static void Start(String username,password) {
        Admin admin = new Admin(username,password);

        System.out.println();
        System.out.println("1.Add Product");
        System.out.println("2.Remove Product");
        System.out.println("3.Change price");
        System.out.println("4.Exit");

        Scanner in = new Scanner(System.in);
        int command = in.nextInt();

        if (command == 1) {
            addProduct(username);
        }else if (command == 2){
            removeProduct(username);
        }else if (command ==3){
            changePrice(username);
        }else {
            Engine.Run();
        }
    }

    private static void changePrice(String username) {
        Scanner in = new Scanner(System.in);
        System.out.println("Products: ");
        allProducts.forEach(x->x.showDescription());

        System.out.print("Change price to product: ");
        int product = in.nextInt();
        System.out.println();
        System.out.print("New price: ");
        double newPrice = in.nextDouble();
        System.out.println();
        allProducts.get(product-1).setPrice(newPrice);
        System.out.println("The price has been changed!");
        Start(username);
    }

    private static void removeProduct(String username) {
        Scanner in = new Scanner(System.in);
        System.out.println("Products: ");
        allProducts.forEach(x->x.showDescription());

        System.out.print("Remove product: ");
        int remove = in.nextInt();

        getAllProducts().remove(remove-1);
        System.out.printf("Product number %d has been removed!",remove);

        Start(username);
    }

    private static void addProduct(String username) {
        Scanner in = new Scanner(System.in);
        System.out.println("1.TV");
        System.out.println("2.Tablet");
        System.out.println("3.Smartphone");
        System.out.println("4.Printer");
        System.out.println("5.MP3 player");
        System.out.println("6.Laptop");
        System.out.println("7.Camera");
        System.out.println("8.Manual Book");
        int product = in.nextInt();
        switch (product) {
            case 1:
                System.out.print("Brand: ");
                in.nextLine();
                String brand = in.nextLine();
                System.out.print("Model: ");
                String model = in.nextLine();
                System.out.print("Description: ");
                String description = in.nextLine();
                System.out.print("Price: ");
                Double price = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String image = in.nextLine();
                System.out.print("Color: ");
                String color = in.nextLine();
                System.out.print("Screen size: ");
                int screenSize = in.nextInt();
                in.nextLine();
                System.out.println();
                System.out.print("Display technology:");
                String str = in.nextLine();
                DisplayTechnologyType displayTechnology = DisplayTechnologyType.valueOf(str.toUpperCase());
                System.out.print("Model Year: ");
                int modelYear = in.nextInt();

                getAllProducts().add(new TV(brand, model, description, price, image, color, screenSize, displayTechnology, modelYear));
                Start(username);
                break;

            case 2:
                System.out.print("Brand: ");
                in.nextLine();
                String brandTablet = in.nextLine();
                System.out.print("Model: ");
                String modelTablet = in.nextLine();
                System.out.print("Description: ");
                String descriptionTablet = in.nextLine();
                System.out.print("Price: ");
                Double priceTablet = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String imageTablet = in.nextLine();
                System.out.print("Color: ");
                String colorTablet = in.nextLine();
                System.out.print("Display size: ");
                int displaySizeTablet = in.nextInt();
                System.out.print("Operation system: ");
                in.nextLine();
                String opSys = in.nextLine();
                OperationSystemType ops = OperationSystemType.valueOf(opSys.toUpperCase());
                System.out.print("Wireless technology: ");
                String wirel = in.nextLine();
                WirelessTechnologyType wirelessTech = WirelessTechnologyType.valueOf(wirel.toUpperCase());

                getAllProducts().add(new Tablet(brandTablet, modelTablet, descriptionTablet, priceTablet, imageTablet, colorTablet, displaySizeTablet, ops, wirelessTech));
                Start(username);break;

            case 3:
                System.out.print("Brand: ");
                in.nextLine();
                String brandPhone = in.nextLine();
                System.out.print("Model: ");
                String modelPhone = in.nextLine();
                System.out.print("Description: ");
                String descriptionPhone = in.nextLine();
                System.out.print("Price: ");
                Double pricePhone = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String imagePhone = in.nextLine();
                System.out.print("Color: ");
                String colorPhone = in.nextLine();
                System.out.print("Camera resolution: ");
                int camRes = in.nextInt();
                System.out.print("Sim slots: ");
                int simSlots = in.nextInt();

                getAllProducts().add(new Smartphone(brandPhone,modelPhone,descriptionPhone,pricePhone,imagePhone,colorPhone,camRes,simSlots));
                Start(username);break;

            case 4:
                System.out.print("Brand: ");
                in.nextLine();
                String brandPrint = in.nextLine();
                System.out.print("Model: ");
                String modelPrint = in.nextLine();
                System.out.print("Description: ");
                String descriptionPrint = in.nextLine();
                System.out.print("Price: ");
                Double pricePrint = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String imagePrint = in.nextLine();
                System.out.print("Color: ");
                String colorPrint = in.nextLine();
                System.out.print("Connectivity: ");
                String connect = in.nextLine();
                System.out.print("Printing speed: ");
                int printSpeed = in.nextInt();

                getAllProducts().add(new Printer(brandPrint,modelPrint,descriptionPrint,pricePrint,imagePrint,colorPrint,connect,printSpeed));
                Start(username);break;

            case 5:
                System.out.print("Brand: ");
                in.nextLine();
                String brandPlayer = in.nextLine();
                System.out.print("Model: ");
                String modelPlayer = in.nextLine();
                System.out.print("Description: ");
                String descriptionPlayer = in.nextLine();
                System.out.print("Price: ");
                Double pricePlayer = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String imagePlayer = in.nextLine();
                System.out.print("Color: ");
                String colorPlayer = in.nextLine();
                System.out.print("Storage: ");
                int storage = in.nextInt();
                System.out.print("Weight: ");
                int weight = in.nextInt();

                getAllProducts().add(new MP3Player(brandPlayer,modelPlayer,descriptionPlayer,pricePlayer,imagePlayer,colorPlayer,storage,weight));
                Start(username);break;

            case 6:
                System.out.print("Brand: ");
                in.nextLine();
                String brandLap = in.nextLine();
                System.out.print("Model: ");
                String modelLap = in.nextLine();
                System.out.print("Description: ");
                String descriptionLap = in.nextLine();
                System.out.print("Price: ");
                Double priceLap = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String imageLap = in.nextLine();
                System.out.print("Color: ");
                String colorLap = in.nextLine();
                System.out.print("Display size: ");
                int displaySize = in.nextInt();
                System.out.print("RAM: ");
                int ram = in.nextInt();
                System.out.print("CPU type: ");
                in.nextLine();
                String cpuType = in.nextLine();

                getAllProducts().add(new Laptop(brandLap,modelLap,descriptionLap,priceLap,imageLap,colorLap,displaySize,ram,cpuType));
                Start(username);break;

            case 7:
                System.out.print("Brand: ");
                in.nextLine();
                String brandCam = in.nextLine();
                System.out.print("Model: ");
                String modelCam = in.nextLine();
                System.out.print("Description: ");
                String descriptionCam = in.nextLine();
                System.out.print("Price: ");
                Double priceCam = in.nextDouble();
                System.out.print("Image: ");
                in.nextLine();
                String imageCam = in.nextLine();
                System.out.print("Color: ");
                String colorCam = in.nextLine();
                System.out.print("Optical zoom: ");
                int opticalZoom = in.nextInt();
                System.out.print("Image stabilization: ");
                boolean imgStab = in.nextBoolean();

                getAllProducts().add(new Camera(brandCam,modelCam,descriptionCam,priceCam,imageCam,colorCam,opticalZoom,imgStab));
                Start(username);break;

            case 8:
                System.out.print("Title: ");
                String title = in.nextLine();
                System.out.print("Author: ");
                String author = in.nextLine();
                System.out.print("Publisher: ");
                String publish = in.nextLine();
                System.out.print("Description: ");
                String descrip = in.nextLine();
                System.out.print("Price: ");
                int priceBook = in.nextInt();
                System.out.print("Image: ");
                in.nextLine();
                String imageBook = in.nextLine();

                getAllProducts().add(new Book(title,author,publish,descrip,priceBook,imageBook));
                Start(username);break;

                default: Start(username);break;
        }
    }
}
