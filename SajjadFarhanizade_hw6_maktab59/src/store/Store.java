package store;

import attribute.Color;
import attribute.Gender;
import attribute.Material;
import store.products.Product;
import store.products.book.Book;
import store.products.book.Magazine;
import store.products.book.Subject;
import store.products.clothes.shoes.FormalShoe;
import store.products.clothes.shoes.SportShoe;
import store.products.electrical.*;

import java.util.Arrays;

public class Store {

    private static Stock stock = new Stock();
    private static Product[][] products;
    private Customer[] customers = new Customer[0];
    private Customer loggedInCustomer;
    private Login login;
    private Object[][][] factors = new Object[0][2][0];

    public Store() {
        loadDefaultProducts();
        products = stock.getProduct();
    }

    public void main() {

        /*addCustomer("sajjad","123","sajjad","farhani",
                "09330886884","123@gmail.com",1000000,
                new Address("Kh.Razavi","Mashhad","Khayyam","123456789"));*//*
        if(login==null)
            return;
        loggedInCustomer = login.getSignedInCustomer();

        if(loggedInCustomer == null)
            return;
        printProducts();
        cart.addToCart(products[0][0], 2);
        //cart.addToCart(products[0][0], 3);
        //cart.addToCart(products[0][1], 3);
        System.out.println(cart.toString());
        //cart.removeFromCart(2);
        System.out.println(cart.toString());
        factor = cart.getFactor(5);
        System.out.println("Total Amount: "+factor.getTotalAmount()+ "\nTotal Price: "+factor.getTotalPrice());
        if(loggedInCustomer.pay(factor.getTotalPrice())) {
            stock.buyProduct(cart.getCartList());
            cart = new Cart();
        }
        System.out.println(loggedInCustomer.getBudget());
        printProducts();
        System.out.println(cart.toString());*/
    }

    protected void addCustomer(String userName, String passWord, String firstName, String lastName, String phone, String email, int budget, Address address){
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length-1]=new Customer(userName, passWord, firstName, lastName, phone, email, budget, address);
    }





    protected void logOut(){
        updateCustomers();
        loggedInCustomer = null;
        login.logOut();
    }

    protected boolean logIn(Object[] loggedInUserInfo){
        login = new Login(customers, loggedInUserInfo);
        if(login.isLoggedIn()) {
            loggedInCustomer = login.getSignedInCustomer();
            return true;
        }
        return false;
    }

    protected void addCustomer(Customer user){
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length-1]= user;
    }

    protected void printProducts(){
        products = Stock.getProduct();
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getClass().getName().substring(products[i].getClass().getName().lastIndexOf(".")+1));
            for (int j = 0; j < products[i].length; j++) {
                System.out.println(products[i][j]);
            }
            System.out.println("=================================");
            System.out.println();
        }
    }

    protected void updateCustomers(){
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getUserName().equals(loggedInCustomer.getUserName()))
                customers[i]=loggedInCustomer;
        }
    }

    protected Customer[] getCustomers(){
        return this.customers;
    }


    public Product[][] getProducts() {
        return products;
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public void setFactor(Factor factor){
        if(factors.length==0){
            factors = new Object[1][2][1];
        }
        if(factors[factors.length-1]==null){
            factors[factors.length-1] = new Object[2][1];
        }
        for (int i = 0; i < factors.length; i++) {
            if(factors[i][0][0]!=null) {
                if (factors[i][0][0].equals(factor.getUserName())) {
                    Arrays.copyOf(factors[i][1], factors[i][1].length + 1);
                    factors[i][1][factors[i][1].length - 1] = factor;
                }
            }
            else {
                factors[i][0][0] = factor.getUserName();
                factors[i][1][0]=factor;
            }
        }
    }

    /*public static Factor getFactor() {
        for (int i = 0; i < factor.length; i++) {
            if(factor[0])
        }
        return factor;
    }*/


    private static void loadDefaultProducts(){
        Book b = new Book(1,"Space",50000,10, Subject.SCIENCE,200,"Oxford",3);
        stock.addProduct(b);
        b = new Book(2,"Lord Of The Ring",300000,10, Subject.STORY,400,"Peterson",2);
        stock.addProduct(b);
        Magazine m = new Magazine(3,"Roshd",20000,10,Subject.SCIENCE,30,"Educa",3);
        stock.addProduct(m);
        m = new Magazine(4,"Cooking",25000,10,Subject.SCIENCE,30,"Educa",5);
        stock.addProduct(m);
        FormalShoe f = new FormalShoe(5,"Bella",560000,20,40, Gender.MALE, Color.BLACK, Material.LEATHER);
        stock.addProduct(f);
        f = new FormalShoe(6,"Bella",560000,20,40, Gender.FEMALE, Color.BROWN, Material.LEATHER);
        stock.addProduct(f);
        SportShoe sp = new SportShoe(7,"Adidas",700000,20,42, Gender.MALE, Color.GREEN, Material.COTTON);
        stock.addProduct(sp);
        sp = new SportShoe(8,"Adidas",700000,20,42, Gender.FEMALE, Color.RED, Material.COTTON);
        stock.addProduct(sp);
        Television t = new Television(9,"LG",12000000,20, Voltage.V220, PowerSource.AC,60, TV_Type.LED,50,new int[]{1920,1080});
        stock.addProduct(t);
        t = new Television(10,"LG",24000000,20, Voltage.V220, PowerSource.AC,70, TV_Type._3D,65,new int[]{2496,1404});
        stock.addProduct(t);
        Radio r = new Radio(11,"JBL",300000,20, Voltage.V220, PowerSource.AC,5,15,SignalModulationMode.FM);
        stock.addProduct(r);
        r = new Radio(12,"JBL",450000,20, Voltage.V110, PowerSource.AC,7,10,SignalModulationMode.SW);
        stock.addProduct(r);



    }




}
