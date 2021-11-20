package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account implements BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private String number;

    @Column(name = "account_balance")
    private Integer balance;

    @Column(name = "account_isLocked")
    private boolean isLocked = false;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number")
    private CreditCard creditCard;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;


    public Account(Integer balance, boolean isLocked, Customer customer, Branch branch) {
        this.balance = balance;
        this.isLocked = isLocked;
        this.customer = customer;
        this.branch = branch;
    }

    public Account() {

    }

    @Override
    public void setId(String s) {

    }

    @Override
    public String getId() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditCard getCreditCards() {
        return creditCard;
    }

    public void setCreditCards(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number.equals(account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, balance, isLocked, customer, creditCard, transactions, branch);
    }

    public static AccountBuilder builder(){
        return new AccountBuilder();
    }

    public static class AccountBuilder{
        private Integer balance;
        private Customer customer;
        private Branch branch;

        public AccountBuilder balance(Integer balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public AccountBuilder branch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public Account build(){
            return new Account(balance,false,customer,branch);
        }
    }
}
