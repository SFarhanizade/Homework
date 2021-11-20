package dao;

import entity.Employee;

import javax.persistence.EntityManager;

public class EmployeeDao extends BaseDao<Employee,Long> {
    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return null;
    }
}
