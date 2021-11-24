package manager;

import dao.EmployeeDao;
import entity.Employee;

import javax.persistence.EntityManager;

public class EmployeeManager extends BaseManager<Employee,Long>{

    public EmployeeManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new EmployeeDao(entityManager));
    }

    public Employee login(String username, String password){
        return new EmployeeDao(entityManager).login(username, password);
    }
    public boolean userExists(String username){
        return new EmployeeDao(entityManager).userExists(username);
    }
}
