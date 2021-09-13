package store;

import java.util.Scanner;

public class Menu {
    private static Scanner input = new Scanner(System.in);
    private static boolean isUserLoggedIn = false;
    private static int menuNum;
    private static Store store = new Store();


    public static void main(String[] args) {
        showMenu();
    }
    public static void showMenu() {
        Menu menu = new Menu();
        if(!isUserLoggedIn){
            System.out.println("1- Sing In");
            System.out.println("2- Sign Up");
            menuNum = input.nextInt();
            if(menuNum==1){
                isUserLoggedIn = store.logIn(menu.getLoggedInUserInfo());
            }else{

                store.addCustomer(menu.getSignedUpUser());
            }
        }
        else {
            System.out.println("Welcome "+ store.getLoggedInCustomer().getFirstName());
            System.out.println("1- Buy Products");
            System.out.println("2- Cart");
            System.out.println("3- Budget");
            System.out.println("4- Sign Out");
            menuNum = input.nextInt();
            input.nextLine();
            switch (menuNum){
                case 1:{
                    store.printProducts();
                    System.out.print("\nEnter the Product ID: ");
                    int id = input.nextInt();
                    System.out.print("Enter the amount: ");
                    int amount = input.nextInt();
                    store.getLoggedInCustomer().addToCart(id, amount);
                    break;
                }
                case 2:{
                    System.out.println(store.getLoggedInCustomer().getCart());
                    if(store.getLoggedInCustomer().getCart().getCartList()[0][1]!=null) {
                        System.out.println("1- Remove an item");
                        System.out.println("2- Pay");
                    }
                    System.out.println("0- Back");
                    menuNum = input.nextInt();
                    if(menuNum==1){
                        System.out.print("Enter the ID to remove: ");
                        menuNum = input.nextInt();
                        store.getLoggedInCustomer().getCart().removeFromCart(menuNum);
                    }else if(menuNum==2){
                        System.out.println();
                        Factor factor = new Factor();
                        factor = store.getLoggedInCustomer().getFactor();
                        System.out.println("Current budget: "+ store.getLoggedInCustomer().getBudget());
                        System.out.println("Price: "+ factor.getTotalPrice());
                        System.out.println("Pay?     1-Yes     2-No");
                        menuNum = input.nextInt();
                        if(menuNum==1){
                            store.setFactor(factor);
                            if(store.getLoggedInCustomer().buy(factor))
                                store.updateCustomers();
                        }
                    }
                    else{
                        menuNum = 0;
                    }
                    break;
                }
                case 3:{
                    System.out.println("Current budget: "+ store.getLoggedInCustomer().getBudget());
                    System.out.println("1- Deposit");
                    System.out.println("2- Back");
                    menuNum = input.nextInt();
                    if(menuNum==1){
                        System.out.print("Enter the amount of money: ");
                        menuNum = input.nextInt();
                        store.getLoggedInCustomer().deposit(menuNum);
                    }else{
                        menuNum = 0;
                    }
                    break;
                }
                case 4:{
                    isUserLoggedIn = false;
                    store.logOut();
                    break;
                }
            }
        }
        showMenu();
    }

    protected Object[] getLoggedInUserInfo(){
        String userName;
        String passWord;
        input.nextLine();
        System.out.print("Username: ");
        userName = input.nextLine();
        System.out.print("Password: ");
        passWord = input.nextLine();
        Object[] user = new Object[2];
        user[0]=userName;
        user[1]=passWord;

        return user;
    }

    protected Customer getSignedUpUser() {
        String userName;
        String passWord;
        String firstName;
        String lastName;
        String phone;
        String email;
        int budget;
        String province;
        String city;
        String street;
        String zipCode;

        input.nextLine();
        System.out.print("Username: ");
        userName = input.nextLine();
        System.out.print("Password: ");
        passWord = input.nextLine();
        System.out.print("First Name: ");
        firstName = input.nextLine();
        System.out.print("Last Name: ");
        lastName = input.nextLine();
        System.out.print("Phone: ");
        phone = input.nextLine();
        System.out.print("Email: ");
        email = input.nextLine();
        System.out.print("Initial Budget: ");
        budget = input.nextInt();
        input.nextLine();
        System.out.println("------Address------");
        System.out.print("Province: ");
        province = input.nextLine();
        System.out.print("City: ");
        city = input.nextLine();
        System.out.print("Street: ");
        street = input.nextLine();
        System.out.print("Zipcode: ");
        zipCode = input.nextLine();

        return new Customer(userName,passWord,firstName,lastName,phone,email,budget,new Address(province,city,street,zipCode));
    }


    private String toString(String s){
        String newStr = "";
        char[] charStr = s.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            newStr+=charStr[i];
        }
        return  newStr;
    }
    private String toString(int i){
        String newStr = "";
        String s = Integer.toString(i);
        char[] charStr = s.toCharArray();
        for (int j = 0; j < charStr.length; j++) {
            newStr+=charStr[j];
        }
        return  newStr;
    }

}
