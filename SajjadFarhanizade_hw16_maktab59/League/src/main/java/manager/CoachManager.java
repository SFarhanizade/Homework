package manager;

import dao.CoachDao;
import entity.Coach;

import java.util.List;

public class CoachManager extends BaseManager<Coach> {
    public List<Coach> loadFreeCoaches() {
        return ((CoachDao) baseDao).loadFreeCoaches();
    }
}
