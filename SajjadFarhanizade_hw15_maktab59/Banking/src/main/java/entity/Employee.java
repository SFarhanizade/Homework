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

    @ManyToOne
    private Branch branch;

    public Employee(String name, Branch branch) {
        this.name = name;
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

    public static EmployeeBuilder bulider(){
        return new EmployeeBuilder();
    }
    public static class EmployeeBuilder{
        private String name;
        private Branch branch;

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder branch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public Employee build(){
            return new Employee(name, branch);
        }
    }
}
