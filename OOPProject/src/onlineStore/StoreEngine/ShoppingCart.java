package onlineStore.StoreEngine;

import onlineStore.Products.Product;

import java.util.ArrayList;

public class ShoppingCart {
    private double totalPrice;
    ArrayList<Product> products;

    public ShoppingCart(){
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void sumTotalPrice(){
        this.products
                .forEach(x -> this.totalPrice += x.getPrice());
    }

    public void listShoppingCartProducts(){
        this.products
                .forEach(x -> x.showDescription());
    }
}
