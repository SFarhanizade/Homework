package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee implements  BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_username", unique = true)
    private String username;

    @Column(name = "employee_password")
    private String password;

    @ManyToOne
    private Branch branch;

    public Employee(String name, String username, String password, Branch branch) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.branch = branch;
    }

    public Employee() {

    }

    @Override
    public void setId(Long s) {

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        Employee employee = (Employee) o;
        return id.equals(employee.id) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
    }
    public static class EmployeeBuilder{
        private String name;
        private String username;
        private String password;
        private Branch branch;

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder username(String username) {
            this.username = username;
            return this;
        }

        public EmployeeBuilder password(String password) {
            this.password = password;
            return this;
        }

        public EmployeeBuilder branch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public Employee build(){
            return new Employee(name,username, password, branch);
        }
    }
}
