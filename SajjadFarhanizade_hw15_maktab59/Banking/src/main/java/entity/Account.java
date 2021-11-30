package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private Long number;

    @Column(name = "account_balance")
    private Integer balance;

    @Column(name = "account_isLocked")
    private boolean isLocked = false;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="account")
    private CreditCard creditCard;


    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private Set<Transaction> origin;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private Set<Transaction> dest;


    public Account(Integer balance, boolean isLocked, Customer customer, Branch branch) {
        this.balance = balance;
        this.isLocked = isLocked;
        this.customer = customer;
        this.branch = branch;
    }

    public Account() {

    }

    @Override
    public void setId(Long s) {

    }

    @Override
    public Long getId() {
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Set<Transaction> getOriginTransactions() {
        return origin;
    }

    public Set<Transaction> getDestTransactions() {
        return dest;
    }

    public void setOriginTransactions(Set<Transaction> transactions) {
        this.origin = transactions;
    }

    public void setDestTransactions(Set<Transaction> transactions) {
        this.dest = transactions;
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
        return Objects.hash(number,customer);
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder {
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

        public Account build() {
            return new Account(balance, false, customer, branch);
        }
    }
}
