package dao;

import entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamDao extends BaseDao<Team>{
    public TeamDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }

    public List<Team> getAllSortedByPoints() {
        TypedQuery<Team> query =
                entityManager.createQuery("From Team t order by points", getEntityClass());
        return query.getResultList();
    }
}
