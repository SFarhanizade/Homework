package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Stadium extends BaseThing{

    @ManyToOne
    private City city;

    @OneToMany
    private List<Game> games;

    public Stadium(City city) {
        this.city = city;
    }

    public Stadium(Long id, String name, City city, List<Game> games) {
        super(id, name);
        this.city = city;
        this.games = games;
    }

    public Stadium() {

    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public static StadiumBuilder builder() {
        return new StadiumBuilder();
    }

    public static class StadiumBuilder{
        private String name;
        private City city;
        private List<Game> games;

        public StadiumBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StadiumBuilder city(City city) {
            this.city = city;
            return this;
        }

        public StadiumBuilder games(List<Game> games) {
            this.games = games;
            return this;
        }

        public Stadium build() {
            return new Stadium(null,name, city,games);
        }
    }
}
