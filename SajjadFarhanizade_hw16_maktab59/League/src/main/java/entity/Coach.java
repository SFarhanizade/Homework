package entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Coach extends BaseThing{

    @OneToOne
    private Team team;

    public Coach() {
    }

    public Coach(String name, Team team) {
        super(name);
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public static CoachBuilder builder() {
        return new CoachBuilder();
    }

    public static class CoachBuilder{
        private String name;
        private Team team;

        public CoachBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CoachBuilder team(Team team) {
            this.team = team;
            return this;
        }

        public Coach build(){
            return new Coach(name,team);
        }
    }
}
