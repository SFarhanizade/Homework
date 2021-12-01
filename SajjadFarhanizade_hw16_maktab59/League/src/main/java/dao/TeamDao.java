package dao;

import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        query.setParameter("team", team);
        return query.getResultList();
    }

    public List<CityTeam> getCitiesTeamNumber() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CityTeam> cq = cb.createQuery(CityTeam.class);
        Root<Team> from = cq.from(Team.class);
        cq.multiselect(from.get("city"), cb.count(from));
        cq.groupBy(from.get("city"));
        TypedQuery<CityTeam> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    public Team getChampion() {
        /*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ContractCoach> cq = cb.createQuery(ContractCoach.class);
        CriteriaQuery<Integer> cqP = cb.createQuery(Integer.class);
        Root<ContractCoach> from = cq.from(ContractCoach.class);
        Root<ContractCoach> from1 = cqP.from(ContractCoach.class);
        cqP.select(cb.max(from1.get("price")));
        TypedQuery<Integer> query1 = entityManager.createQuery(cqP);
        int max = query1.getSingleResult();
        cq.multiselect(from.get("coach"),from.get("team"),from.get("price"), from.get("year"));
        cq.where(cb.equal(from.get("price"),max));
        TypedQuery<ContractCoach> query = entityManager.createQuery(cq);
        return query.getResultList();*/

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Team> cq = cb.createQuery(Team.class);
        CriteriaQuery<Integer> cqP = cb.createQuery(Integer.class);
        Root<Team> from = cq.from(Team.class);
        Root<Team> from1 = cqP.from(Team.class);
        cqP.select(cb.max(from1.get("points")));
        TypedQuery<Integer> query1 = entityManager.createQuery(cqP);
        int max = query1.getSingleResult();
        cq.multiselect(from.get("name"),from.get("points"));
        cq.where(cb.equal(from.get("points"),max));
        TypedQuery<Team> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }
}
