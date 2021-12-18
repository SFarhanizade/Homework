package ir.farhanizade.busticket.entity;

import ir.farhanizade.busticket.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;

@Entity
public class Travel extends BaseEntity {

    @ManyToOne
    private City origin;

    @ManyToOne
    private City destination;

    private Date date;

    private Time time;

    public Travel(City origin, City destination, Date date, Time time) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
    }

    public Travel() {
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public static TravelBuilder builder(){
        return new TravelBuilder();
    }

    public static class TravelBuilder{
        private City origin;
        private City destination;
        private Date date;
        private Time time;

        public TravelBuilder origin(City origin){
            this.origin = origin;
            return this;
        }

        public TravelBuilder destination(City city){
            this.destination = destination;
            return this;
        }

        public TravelBuilder date(Date date){
            this.date = date;
            return this;
        }

        public TravelBuilder time(Time time){
            this.time = time;
            return this;
        }

        public Travel build(){
            return new Travel(origin,destination,date,time);
        }
    }
}
