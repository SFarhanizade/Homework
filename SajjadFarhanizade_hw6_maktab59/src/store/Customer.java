package store;

public class Customer {
    private  String userName;
    private String passWord;
    private  String firstName;
    private  String lastName;
    private  String phone;
    private  String email;
    private int budget;
    private  Address address;
    private  Cart cart = new Cart();
    private  Factor factor;

    public Customer(String userName, String passWord, String firstName, String lastName, String phone, String email, int budget, Address address) {
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.budget = budget;
        this.address = address;
    }

    public Customer(Object[] user) {
        this.userName = user[0].toString();
        this.passWord = user[1].toString();
        this.firstName = user[2].toString();
        this.lastName = user[3].toString();
        this.phone = user[4].toString();
        this.email = user[5].toString();
        this.budget = Integer.parseInt(user[6].toString());
        this.address = (Address) user[7];
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Factor getFactor() {
        return cart.getFactor(cart.getCartList().length*userName.length()+Integer.parseInt(phone),this);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void deposit(int money) {
        budget += money;
    }

    public int getBudget() {
        return budget;
    }

    public boolean pay(int money) {
        if (budget - money >= 0) {
            budget -= money;
            return true;
        } else {
            System.out.println("Out Of Money!");
            return false;
        }
    }

    protected boolean buy(Factor factor){
        if(pay(factor.getTotalPrice())) {
            Stock.updateProducts(cart.getCartList());
            cart = new Cart();
            return true;
        }
        return false;
    }

    protected  void addToCart(int id, int amount) {
        cart.addToCart(id, amount);
    }

    protected  Cart getCart() {
        return cart;
    }
}
