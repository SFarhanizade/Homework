package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.CityDao;
import ir.farhanizade.busticket.entity.City;

public class CityService extends BaseService<City> {
    public CityService() {
        baseDao = new CityDao(entityManager);
    }
}
