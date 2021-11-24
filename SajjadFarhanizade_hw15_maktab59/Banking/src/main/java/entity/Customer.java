package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_nationalId", unique = true)
    private String nationalId;

    @Column(name = "customer_name")
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Account> accounts;


    public Customer() {

    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Customer(String nationalId, String name, Set<Account> accounts) {
        this.nationalId = nationalId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static class CustomerBuilder {
        private String nationalId;
        private String name;
        private Set<Account> accounts;

        public CustomerBuilder nationalId(String nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder accounts(Set<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public Customer build() {
            return new Customer(nationalId, name, accounts);
        }
    }
}
