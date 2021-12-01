package manager;

import dao.CityDao;
import entity.BaseEntity;
import entity.City;

public class CityManager extends BaseManager<City>{
    public CityManager() {
        baseDao = new CityDao(entityManager);
    }
}
