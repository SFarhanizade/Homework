package dao;

import entity.City;
import entity.CityTeam;
import entity.ContractPlayer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CityDao extends BaseDao<City>{
    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }

    public List<CityTeam> getCitiesTeamNumber() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CityTeam> cq = cb.createQuery(CityTeam.class);
        Root<City> from = cq.from(City.class);
        cq.multiselect(from.get("name"),cb.count(from.get("team")));
        TypedQuery<CityTeam> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
