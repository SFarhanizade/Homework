package store;

public class Customer {
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int budget;
private Address address;

    public Customer(String userName, String passWord, String firstName, String lastName, String phone, String email, Address address) {
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public void deposit(int money){
        budget+=money;
    }

    public void pay(int money) {
        if(budget-money>=0)
            budget-=money;
        else{
            System.out.println("Out Of Money!");
            return;
        }
    }
}
