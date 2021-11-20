package dao;

import entity.Customer;

import javax.persistence.EntityManager;

public class CustomerDao extends BaseDao<Customer,Long> {

    public CustomerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
