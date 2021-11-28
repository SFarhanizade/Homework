package dao;

import entity.Team;

import javax.persistence.EntityManager;

public class TeamDao extends BaseDao<Team>{
    public TeamDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }
}
