package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.TravelDao;
import ir.farhanizade.busticket.entity.Travel;

import java.time.LocalDate;
import java.util.List;

public class TravelService extends BaseService<Travel> {
    public TravelService() {
        baseDao = new TravelDao(entityManager);
    }

    public List<Travel> getTravels(int origin, int destination, LocalDate localDate) {
        return ((TravelDao) baseDao).getTravels(origin, destination, localDate);
    }
}
