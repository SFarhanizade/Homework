package dao;

import entity.Coach;
import entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeamDao extends BaseDao<Team> {
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

    public List<Team> getAllCoachLessTeam() {
        TypedQuery<Team> query =
                entityManager.createQuery("From Team t where t.coach is null", getEntityClass());
        return query.getResultList();
    }

    public List<Team> getValidTeams() {
        TypedQuery<Team> query = entityManager.createQuery
                ("From Team t where t.players.size>4 and t.coach is not null and t.capitan is not null",
                        getEntityClass());
        return query.getResultList();
    }

    public List<Team> getValidTeams(Team team) {
        TypedQuery<Team> query = entityManager.createQuery
                ("From Team t where  not t=:team and t.players.size>4 and t.coach is not null and t.capitan is not null",
                        getEntityClass());
        query.setParameter("team",team);
        return query.getResultList();
    }
}
