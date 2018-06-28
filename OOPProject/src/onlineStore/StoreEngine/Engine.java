package onlineStore.StoreEngine;

import java.util.Scanner;

public class Engine {

    Store store = new Store();

    public void Run() {
        Scanner in = new Scanner(System.in);

        //System.out.println();
        //System.out.print("Enter your username:");
        //String username = in.nextLine();
        //System.out.println("Enter your password:");
        //String password = in.nextLine();
        //System.out.println();
//
        //System.out.println("What kind of user are you:");
        //System.out.println("1.Admin");
        //System.out.println("2.Customer");
//
        //int input = in.nextInt();
        //if (input== 1){
        //    Admin newAdmin = new Admin(username,password);
        //    newAdmin.logIn();
        //    AdminEngine.Start(username);
        //}

        System.out.println();
        System.out.println("Menu:");
        System.out.println("1.Register new Admin");
        System.out.println("2.Register new Customer");
        System.out.println("3.Admin log in");
        System.out.println("4.Customer log in");
        System.out.println();
        System.out.print("Command: ");

        int command = in.nextInt();

        System.out.println();

        if (command == 1) {
            adminRegistration();
        } else if (command == 2) {
            customerRegistration();
        } else if (command == 3) {
            adminLogIn();
        }

    }



    void adminRegistration() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String usernameAdminReg = in.nextLine();
        System.out.println();
        System.out.print("Enter password: ");
        String passwordAdminReg = in.nextLine();
        System.out.println();
        store.registerAdmin(usernameAdminReg, passwordAdminReg);
        System.out.printf("Username %s has been registered!,", usernameAdminReg);
        Run();
    }

    void customerRegistration(){

    }

    private void adminLogIn() {

    }
}
