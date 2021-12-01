package dao;

import entity.Coach;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CoachDao extends BaseDao<Coach>{
    public CoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }

    public List<Coach> loadFreeCoaches() {
        TypedQuery<Coach> query =
                entityManager.createQuery("From Coach c where c.team=null", getEntityClass());
        return query.getResultList();
    }
}
