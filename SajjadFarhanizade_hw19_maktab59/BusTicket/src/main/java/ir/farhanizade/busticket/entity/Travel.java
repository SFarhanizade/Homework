package ir.farhanizade.busticket.entity;

import com.sun.istack.Nullable;
import ir.farhanizade.busticket.core.BaseEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Travel extends BaseEntity {

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private City origin;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private City destination;

    private LocalDate date;

    private Time time;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Travel(City origin, City destination, LocalDate date, Time time) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        private LocalDate date;
        private Time time;

        public TravelBuilder origin(City origin){
            this.origin = origin;
            return this;
        }

        public TravelBuilder destination(City destination){
            this.destination = destination;
            return this;
        }

        public TravelBuilder date(LocalDate date){
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
