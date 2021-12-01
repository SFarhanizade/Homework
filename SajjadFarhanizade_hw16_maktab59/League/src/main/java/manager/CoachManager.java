package manager;

import dao.CoachDao;
import entity.Coach;

import java.util.List;

public class CoachManager extends BaseManager<Coach> {
    public CoachManager() {
        baseDao = new CoachDao(entityManager);
    }

    public List<Coach> loadFreeCoaches() {
        return ((CoachDao) baseDao).loadFreeCoaches();
    }
}
