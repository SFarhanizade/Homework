package entity;

public class CityTeam {
    private City city;
    private Long number;

    public CityTeam(City city, Long number) {
        this.city = city;
        this.number = number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
