package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.TravelDao;
import ir.farhanizade.busticket.entity.Travel;

public class TravelService extends BaseService<Travel> {
    public TravelService() {
        baseDao= new TravelDao(entityManager);
    }
}
