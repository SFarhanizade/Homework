package entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class City extends BaseThing{

    public City(Long id, String name) {
        super(id, name);
    }
}
