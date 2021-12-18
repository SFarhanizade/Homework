package ir.farhanizade.busticket.entity;

import ir.farhanizade.busticket.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City extends BaseEntity {

    private String name;

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CityBuilder builder(){
        return new CityBuilder();
    }

    static class CityBuilder{
        private String name;

        public CityBuilder name(String name){
            this.name = name;
            return this;
        }

        public City build(){
            return new City(name);
        }
    }
}
