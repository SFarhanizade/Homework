package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Player extends BaseThing {

    @OneToMany(mappedBy = "player")
    private List<ContractPlayer> contracts;

    @ManyToOne
    private Team team;

    public Player() {
    }

    public Player(String name, Team team) {
        super(name);
        this.team = team;
    }

    public List<ContractPlayer> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractPlayer> contracts) {
        this.contracts = contracts;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {
        private String name;
        private Team team;

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder team(Team team) {
            this.team = team;
            return this;
        }

        public Player build() {
            return new Player(name, team);
        }
    }
}
