package dao;

import entity.City;

import javax.persistence.EntityManager;

public class CityDao extends BaseDao<City>{
    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
