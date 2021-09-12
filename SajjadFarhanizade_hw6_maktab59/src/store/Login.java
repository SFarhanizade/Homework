package store;

public class Login {
    private Customer signedInCustomer;
    private String userName;
    private String passWord;

    public Login(Customer[] customers, String userName, String passWord) {
        boolean isLoggedIn = false;
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getUserName()== userName && customers[i].getPassWord()==passWord){
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

    public Customer getSignedInCustomer(){
        return signedInCustomer;
    }
}
