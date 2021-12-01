package entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Coach extends BaseThing{

    @OneToMany(mappedBy="coach")
    private List<ContractCoach> contracts;

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

    public List<ContractCoach> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractCoach> contracts) {
        this.contracts = contracts;
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
