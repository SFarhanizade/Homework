package manager;

import dao.EmployeeDao;
import entity.Employee;

import javax.persistence.EntityManager;

public class EmployeeManager extends BaseManager<Employee,Long>{

    public EmployeeManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new EmployeeDao(entityManager));
    }
}
