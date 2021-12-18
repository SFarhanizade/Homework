package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.City;

import javax.persistence.EntityManager;

public class CityDao extends BaseDao<City> {
    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
