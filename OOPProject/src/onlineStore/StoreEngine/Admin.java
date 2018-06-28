package onlineStore.StoreEngine;

import onlineStore.Forum.Message;
import onlineStore.Products.Product;

import java.util.List;

public class Admin extends User {


    public Admin(String username, String password) {
        super(username, password);
    }

    public void listMessages(List<Message> messages) {
        for (Message mess : messages) {
            System.out.println(mess);
        }
    }

    @Override
    void logIn(User user, Store store) {
        if (user instanceof Admin) {
            if (store.validateAdmin(user.getUsername(), user.getPassword())) {
                System.out.printf("Admin %s has logged in.", this.getUsername());
            }else {
                System.out.println("Incorrect username or password!");
            }
        }else {
            System.out.println("This user is not admin or does not exist!");
        }
    }

    public void changePrice(Product product, double price) {
        product.setPrice(price);
    }

    public void addProduct(Product product, Store store){
        store.addProduct(product);
    }

    public void removeProduct(Product product,Store store){
        store.removeProduct(product);
    }
}
