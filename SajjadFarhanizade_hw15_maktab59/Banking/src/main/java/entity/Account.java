package entity;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCards;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;


    public Account(Integer balance, Customer customer, Set<CreditCard> creditCards, Set<Transaction> transactions) {
        this.balance = balance;
        this.customer = customer;
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

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
