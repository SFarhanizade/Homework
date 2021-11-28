package entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Coach extends BaseThing{

    @OneToOne
    private Team team;

    public Coach() {
    }

    public Coach(Long id, String name, Team team) {
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
