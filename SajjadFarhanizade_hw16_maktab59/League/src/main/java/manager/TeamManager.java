package manager;

import dao.TeamDao;
import entity.Coach;
import entity.Player;
import entity.Team;

import java.util.List;

public class TeamManager extends BaseManager<Team>{


    public void add(Team entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void save(Team entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        Coach coach = entity.getCoach();
        coach.setTeam(entity);
        entityManager.merge(entity);
        List<Player> players = entity.getPlayers();
        for (Player player : players) {
            player.setTeam(entity);
            entityManager.merge(player);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Team entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        Coach coach = entity.getCoach();
        coach.setTeam(entity);
        entityManager.merge(entity);
        List<Player> players = entity.getPlayers();
        for (Player player : players) {
            player.setTeam(entity);
            entityManager.merge(player);
        }
        entityManager.getTransaction().commit();
    }

    public TeamManager() {
        baseDao = new TeamDao(entityManager);
    }

    public List<Team> getAllSortedByPoints() {
        return ((TeamDao)baseDao).getAllSortedByPoints();
    }

    public List<Team> getAllCoachLessTeam() {
        return ((TeamDao)baseDao).getAllCoachLessTeam();
    }

    public List<Team> getValidTeams() {
       return  ((TeamDao)baseDao).getValidTeams();
    }

    public List<Team> getValidTeams(Team team) {
        return  ((TeamDao)baseDao).getValidTeams(team);
    }
}
