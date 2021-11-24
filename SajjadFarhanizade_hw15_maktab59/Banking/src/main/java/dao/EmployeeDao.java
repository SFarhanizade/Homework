package dao;

import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDao extends BaseDao<Employee,Long> {
    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    public Employee login(String username, String password){
        entityManager.getTransaction().begin();
        TypedQuery<Employee> query = entityManager.createQuery("From Employee e where e.username=:username AND e.password=:password"
                , getEntityClass());
        query.setParameter("username",username);
        query.setParameter("password",password);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        if (employees==null)
            return null;
        return employees.get(0);
    }

    public boolean userExists(String username){
        entityManager.getTransaction().begin();
        TypedQuery<Employee> query =
                entityManager.createQuery("From Employee e where e.username=:username", getEntityClass());
        query.setParameter("username", username);
        List<Employee> result = query.getResultList();
        entityManager.getTransaction().commit();
        return result.size()>0;
    }
}
