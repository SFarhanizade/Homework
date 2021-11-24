package dao;

import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDao extends BaseDao<Customer, Long> {

    public CustomerDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean exists(String nationalId) {
        entityManager.getTransaction().begin();
        TypedQuery<Customer> query =
                entityManager.createQuery("From Customer c where c.nationalId=:nationalId",
                        Customer.class);
        query.setParameter("nationalId", nationalId);
        List<Customer> result = query.getResultList();
        entityManager.getTransaction().commit();
        return result.size() > 0;
    }

    public Customer loadByNationalId(String nationalId) {
        entityManager.getTransaction().begin();
        TypedQuery<Customer> query =
                entityManager.createQuery("From Customer c where c.nationalId=:nationalId",
                        getEntityClass());
        query.setParameter("nationalId", nationalId);
        List<Customer> result = query.getResultList();
        entityManager.getTransaction().commit();
        if (result.size() == 1)
            return result.get(0);
        return null;
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
