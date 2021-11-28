package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Stadium extends BaseThing{

    @ManyToOne
    private City city;

    public Stadium(City city) {
        this.city = city;
    }

    public Stadium(Long id, String name, City city) {
        super(id, name);
        this.city = city;
    }

    public Stadium() {

    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
