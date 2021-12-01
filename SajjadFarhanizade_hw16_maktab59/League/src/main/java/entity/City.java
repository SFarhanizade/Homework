package entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class City extends BaseThing{

    @OneToMany(mappedBy = "city")
    private List<Stadium> stadiums;

    @OneToMany(mappedBy = "city")
    private List<Team> teams;

    public City(Long id, String name) {
        super(id, name);
    }

    public City() {
        super();
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public static CityBuilder builder(){
        return new CityBuilder();
    }

    public static class CityBuilder{
        private String name;

        public CityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public City build() {
            return new City(null,name);
        }
    }
}
