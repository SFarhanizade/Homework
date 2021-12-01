package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Game extends BaseEntity{
    @ManyToOne
    private Stadium stadium;

    @ManyToOne
    private Team team1;

    @ManyToOne
    private Team team2;


    private Integer firstTeamGoals;

    private Integer secondTeamGoals;

    @ManyToOne
    private Team winner;

    private Integer year;

    public Game(Stadium stadium, Team team1, Team team2,
                Integer firstTeamGoals, Integer secondTeamGoals, Integer year) {
        super();
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
        this.firstTeamGoals = firstTeamGoals;
        this.secondTeamGoals = secondTeamGoals;
        this.year = year;

        if(firstTeamGoals>secondTeamGoals)
            winner = team1;
        else if(secondTeamGoals>firstTeamGoals)
            winner = team2;
        else
            winner = null;

        if(winner!=null)
            winner.setPoints(winner.getPoints()+3);
    }

    public Game() {

    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Integer getFirstTeamGoals() {
        return firstTeamGoals;
    }

    public void setFirstTeamGoals(Integer firstTeamGoals) {
        this.firstTeamGoals = firstTeamGoals;
    }

    public Integer getSecondTeamGoals() {
        return secondTeamGoals;
    }

    public void setSecondTeamGoals(Integer secondTeamGoals) {
        this.secondTeamGoals = secondTeamGoals;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public static class GameBuilder{
        private Stadium stadium;
        private Team team1;
        private Team team2;
        private Integer goals1;
        private Integer goals2;
        private Integer year;

        public GameBuilder team1(Team team1) {
            this.team1 = team1;
            return this;
        }

        public GameBuilder team2(Team team2) {
            this.team2 = team2;
            return this;
        }

        public GameBuilder goals1(Integer goals1) {
            this.goals1 = goals1;
            return this;
        }

        public GameBuilder goals2(Integer goals2) {
            this.goals2 = goals2;
            return this;
        }

        public GameBuilder year(Integer year) {
            this.year = year;
            return this;
        }

        public GameBuilder stadium(Stadium stadium) {
            this.stadium = stadium;
            return this;
        }

        public Game build(){
            return new Game(stadium,team1,team2,goals1,goals2,year);
        }
    }
}
