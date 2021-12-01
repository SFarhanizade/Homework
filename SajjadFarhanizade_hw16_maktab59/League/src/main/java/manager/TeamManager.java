package manager;

import dao.TeamDao;
import entity.Team;

import java.util.List;

public class TeamManager extends BaseManager<Team>{
    public List<Team> getAllSortedByPoints() {
        return ((TeamDao)baseDao).getAllSortedByPoints();
    }
}
