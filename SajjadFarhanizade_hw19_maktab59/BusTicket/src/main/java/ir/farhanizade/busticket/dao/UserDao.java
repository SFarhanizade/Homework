package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao extends BaseDao<User> {
    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public User login(String username, String password) {
        TypedQuery<User> query = entityManager.createQuery(
                "From User u Where u.username=:username AND u.password=:password",
                getEntityClass());
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> resultList = query.getResultList();
        if (resultList.size() == 1)
            return resultList.get(0);
        return null;
    }

    public User loadByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("From User u where u.username=:username",
                getEntityClass());
        query.setParameter("username", username);
        List<User> resultList = query.getResultList();
        if(resultList.size()==1)
            return resultList.get(0);
        return null;
    }
}
