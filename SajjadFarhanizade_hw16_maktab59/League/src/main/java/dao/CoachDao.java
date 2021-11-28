package dao;

import entity.Coach;

import javax.persistence.EntityManager;

public class CoachDao extends BaseDao<Coach>{
    public CoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }
}
