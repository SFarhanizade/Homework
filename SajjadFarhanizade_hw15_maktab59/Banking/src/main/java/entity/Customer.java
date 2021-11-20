package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer implements  BaseEntity<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private String id;

    @Column(name = "customer_name")
    private String name;

    @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
    private Set<Account> accounts;

    public Customer() {

    }

    @Override
    public void setId(String id) {
    }

    @Override
    public String getId() {
        return id;
    }

    public Customer(String name, Set<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
