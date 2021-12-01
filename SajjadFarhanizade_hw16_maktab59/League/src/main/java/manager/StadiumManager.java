package manager;

import dao.StadiumDao;
import entity.Stadium;

public class StadiumManager extends BaseManager<Stadium> {
    public StadiumManager() {
        baseDao = new StadiumDao(entityManager);
    }
}
