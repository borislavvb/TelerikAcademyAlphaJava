package onlineStore.Interfaces;

import onlineStore.StoreEngine.Customer;

public interface PasswordChangeable {

    boolean validatePassword(Customer username,String password);

    abstract void changePassword(Customer username, String oldPassword, String newPassword);
}
