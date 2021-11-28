package entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class City extends BaseThing{

    @OneToMany(mappedBy = "city")
    private List<Stadium> stadiums;

    public City(Long id, String name) {
        super(id, name);
    }

    public City() {
        super();
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
