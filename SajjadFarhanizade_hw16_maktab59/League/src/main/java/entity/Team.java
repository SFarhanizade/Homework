package entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Team extends BaseThing{

    @OneToOne
    private Coach coach;

    @OneToMany
    private List<Player> players;

    @OneToOne
    private Player capitan;

    private Integer points;

    public Team() {
    }

    public Team(Long id, String name, Coach coach, List<Player> players) {
        super(id, name);
        this.coach = coach;
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCapitan() {
        return capitan;
    }

    public void setCapitan(Player capitan) {
        this.capitan = capitan;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
