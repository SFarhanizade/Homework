package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Player extends BaseThing{

@ManyToOne
private Team team;

    public Player() {
    }

    public Player(Long id, String name, Team team) {
        super(id, name);
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
