package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.User;

import javax.persistence.EntityManager;

public class UserDao extends BaseDao<User> {
    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
