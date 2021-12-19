package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.Travel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class TravelDao extends BaseDao<Travel> {
    public TravelDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Travel> getTravels(int origin, int destination, LocalDate localDate) {
        TypedQuery<Travel> query = entityManager.createQuery(
                "From Travel t " +
                        "where t.origin.id=:origin and t.destination.id=:destination and t.date=:localDate"
                , getEntityClass());
        query.setParameter("origin", origin);
        query.setParameter("destination", destination);
        query.setParameter("localDate", localDate);
        List<Travel> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }
}
