package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Branch implements BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private String id;

    @Column(name = "branch_name")
    private String name;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private Set<Account> accounts;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.MERGE)
    private Set<Employee> employees;

    public Branch(String name) {
        this.name = name;
    }

    public Branch(String name, Set<Account> accounts, Set<Employee> employees) {
        this.name = name;
        this.accounts = accounts;
        this.employees = employees;
    }

    public Branch() {

    }

    @Override
    public void setId(String s) {

    }

    @Override
    public String getId() {
        return id;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static BranchBuilder builder(){
        return new BranchBuilder();
    }

    public static class BranchBuilder{
        private String name;
        private Set<Account> accounts;
        private Set<Employee> employees;

        public BranchBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BranchBuilder accounts(Set<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public BranchBuilder employees(Set<Employee> employees) {
            this.employees = employees;
            return this;
        }

        public Branch build(){
            return new Branch(name,accounts,employees);
        }
    }

}
