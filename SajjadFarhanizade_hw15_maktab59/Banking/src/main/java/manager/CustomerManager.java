package manager;

import dao.CustomerDao;
import entity.Customer;

import javax.persistence.EntityManager;

public class CustomerManager extends BaseManager<Customer,Long>{

    public CustomerManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new CustomerDao(entityManager));
    }

    public boolean exists(String nationalId) {
        return new CustomerDao(entityManager).exists(nationalId);
    }

    public Customer loadByNationalId(String nationalId) {
        return new CustomerDao(entityManager).loadByNationalId(nationalId);
    }
}
