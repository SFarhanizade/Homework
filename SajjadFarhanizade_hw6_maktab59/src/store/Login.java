package store;

public class Login {
    private Customer signedInCustomer;
    private String userName;
    private String passWord;
    private boolean isLoggedIn = false;

    public Login(Customer[] customers, String userName, String passWord) {
        boolean isLoggedIn = false;
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getUserName().equals(userName) && customers[i].getPassWord().equals(passWord)){
                signedInCustomer = customers[i];
                isLoggedIn = true;
                break;
            }
        }
        if(!isLoggedIn){
            System.out.println("Wrong UserName or Password!");
            return;
        }
        this.userName = userName;
        this.passWord = passWord;
    }

    public Login(Customer[] customers, Object[] user) {
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getUserName().equals(user[0].toString()) && customers[i].getPassWord().equals(user[1].toString())){
                signedInCustomer = customers[i];
                isLoggedIn = true;
                break;
            }
        }
        if(!isLoggedIn){
            System.out.println("Wrong UserName or Password!");
            return;
        }
        this.userName = user[0].toString();
        this.passWord = user[1].toString();
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void logOut() {
         signedInCustomer = null;
         passWord = null;
         userName = null;
    }

    public Customer getSignedInCustomer(){
        return signedInCustomer;
    }
}
