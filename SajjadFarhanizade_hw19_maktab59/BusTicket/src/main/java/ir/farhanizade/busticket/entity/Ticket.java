package ir.farhanizade.busticket.entity;

import ir.farhanizade.busticket.core.BaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ticket extends BaseEntity {

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Travel travel;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private User owner;

    public Ticket(Travel travel, User owner) {
        this.travel = travel;
        this.owner = owner;
    }

    public Ticket() {
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public static TicketBuilder builder(){
        return new TicketBuilder();
    }

    public static class TicketBuilder{
        private Travel travel;
        private User owner;

        public TicketBuilder travel(Travel travel){
            this.travel = travel;
            return this;
        }

        public TicketBuilder owner(User owner){
            this.owner = owner;
            return this;
        }

        public Ticket build(){
            return new Ticket(travel,owner);
        }
    }
}
