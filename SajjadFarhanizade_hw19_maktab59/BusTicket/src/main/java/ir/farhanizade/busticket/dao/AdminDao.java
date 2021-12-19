package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.Admin;
import ir.farhanizade.busticket.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdminDao extends BaseDao<Admin> {
    public AdminDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    public Admin login(String username, String password) {
        TypedQuery<Admin> query = entityManager.createQuery(
                "From Admin a Where a.username=:username AND a.password=:password",
                getEntityClass());
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Admin> resultList = query.getResultList();
        if (resultList.size() == 1)
            return resultList.get(0);
        return null;
    }
}
