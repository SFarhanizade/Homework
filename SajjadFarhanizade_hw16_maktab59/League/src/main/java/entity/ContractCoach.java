package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ContractCoach extends BaseEntity{
    @ManyToOne
    private Coach coach;

    @ManyToOne
    private Team team;

    private Integer price;

    private Integer year;

    public ContractCoach(Coach coach, Team team, Integer price, Integer year) {
        this.coach = coach;
        this.team = team;
        this.price = price;
        this.year = year;
    }

    public ContractCoach() {

    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public static ContractCoachBuilder builder() {
        return new ContractCoachBuilder();
    }

    public static class ContractCoachBuilder{
        private Coach coach;
        private Team team;
        private Integer price;
        private Integer year;


        public ContractCoachBuilder coach(Coach coach) {
            this.coach = coach;
            return this;
        }

        public ContractCoachBuilder team(Team team) {
            this.team = team;
            return this;
        }

        public ContractCoachBuilder price(Integer price) {
            this.price = price;
            return this;
        }
        public ContractCoachBuilder year(Integer year) {
            this.year = year;
            return this;
        }

        public ContractCoach build(){
            return new ContractCoach(coach,team,price, year);
        }
    }
}
