package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.Travel;

import javax.persistence.EntityManager;

public class TravelDao extends BaseDao<Travel> {
    public TravelDao(EntityManager entityManager) {
        super(entityManager);
    }
}
