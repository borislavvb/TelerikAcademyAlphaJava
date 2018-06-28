package onlineStore.StoreEngine;

import onlineStore.Interfaces.Renameable;

public class Customer extends User implements Renameable {
    private static int ID = 0;
    private String name;
    private String creditCardNumber;
    private ShoppingCart shoppingCart;
    private String address;

    public Customer(String username, String password, String name, String creditCardNumber, String address) {
        super(username,password);
        this.creditCardNumber = creditCardNumber;
        this.address = address;
        this.name = name;
        shoppingCart = new ShoppingCart();
        ID++;
    }

    public String getName() {
        return name;
    }

    public static int getID() {
        return ID;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    void logIn() {
        System.out.printf("Customer %s has logged in.", this.getUsername());
    }

    @Override
    public void changeUsername(String name) {
        this.setUsername(name);
    }


}
