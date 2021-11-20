package entity;

import javax.persistence.*;

@Entity
public class Employee implements  BaseEntity<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "employee_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public Employee(String name, Branch branch) {
        this.name = name;
        this.branch = branch;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {

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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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
