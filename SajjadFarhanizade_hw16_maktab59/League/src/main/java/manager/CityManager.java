package manager;

import dao.CityDao;
import entity.BaseEntity;
import entity.City;
import entity.CityTeam;

import java.util.List;

public class CityManager extends BaseManager<City>{
    public CityManager() {
        baseDao = new CityDao(entityManager);
    }

    public List<CityTeam> getCitiesTeamNumber() {
        return ((CityDao) baseDao).getCitiesTeamNumber();    }
}
