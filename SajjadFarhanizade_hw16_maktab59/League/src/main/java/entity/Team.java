package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Team extends BaseThing{

    @ManyToOne
    private City city;

    @OneToMany(mappedBy="team")
    private List<ContractCoach> coachContracts;

    @OneToMany(mappedBy="team")
    private List<ContractPlayer> playerContracts;

    @OneToOne
    private Coach coach;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @OneToOne
    private Player capitan;

    @OneToMany
    private List<Game> games;

    private Integer points = 0;


    public List<ContractCoach> getCoachContracts() {
        return coachContracts;
    }

    public void setCoachContracts(List<ContractCoach> coachContracts) {
        this.coachContracts = coachContracts;
    }

    public Team() {
    }

    public Team(String name, City city, Coach coach, List<Player> players,
                Player capitan) {
        super(name);
        this.city = city;
        this.coach = coach;
        this.players = players;
        this.capitan = capitan;
    }

    public Team(String name,int points) {
        super(name);
        this.points = points;
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }

    public static class TeamBuilder{
        private String name;
        private City city;
        private Coach coach;
        private List<Player> players;
        private Player capitan;

        public TeamBuilder name(String name) {
            this.name = name;
            return this;
        }
        public TeamBuilder city(City city) {
            this.city = city;
            return this;
        }

        public TeamBuilder coach(Coach coach) {
            this.coach = coach;
            return this;
        }

        public TeamBuilder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public TeamBuilder capitan(Player capitan) {
            this.capitan = capitan;
            return this;
        }

        public Team build(){
            return new Team(name, city, coach,players,capitan);
        }
    }
}
