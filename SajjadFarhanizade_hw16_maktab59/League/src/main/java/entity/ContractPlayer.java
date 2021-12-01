package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ContractPlayer extends BaseEntity{
    @ManyToOne
    private Player player;

    @ManyToOne
    private Team team;

    private Integer price;
    private Integer year;

    public ContractPlayer(Player player, Team team, Integer price, Integer year) {
        this.player = player;
        this.team = team;
        this.price = price;
        this.year = year;
    }

    public ContractPlayer() {

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public static ContractPlayerBuilder builder() {
        return new ContractPlayerBuilder();
    }

    public static class ContractPlayerBuilder {
        private Player player;
        private Team team;
        private Integer price;
        private Integer year;

        public ContractPlayerBuilder player(Player player) {
            this.player = player;
            return this;
        }

        public ContractPlayerBuilder team(Team team) {
            this.team = team;
            return this;
        }

        public ContractPlayerBuilder price(Integer price) {
            this.price = price;
            return this;
        }

        public ContractPlayerBuilder year(Integer year) {
            this.year = year;
            return this;
        }

        public ContractPlayer build(){
            return new ContractPlayer(player,team,price, year);
        }
    }
}
