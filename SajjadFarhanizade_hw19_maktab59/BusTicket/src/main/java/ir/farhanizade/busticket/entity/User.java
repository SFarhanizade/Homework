package ir.farhanizade.busticket.entity;

import ir.farhanizade.busticket.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseEntity {

    private String fName;
    private String lName;
    private String username;
    private String password;
    private Gender gender;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public User(String fName, String lName, String username, String password, Gender gender, List<Ticket> tickets) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.tickets = tickets;
    }

    public User(String fName, String lName, String username, String password, Gender gender) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public User() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket){
        if(tickets == null){
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String fName;
        private String lName;
        private String username;
        private String password;
        private Gender gender;

        public UserBuilder fName(String fName){
            this.fName = fName;
            return this;
        }

        public UserBuilder lName(String lName){
            this.lName = lName;
            return this;
        }

        public UserBuilder username(String username){
            this.username = username;
            return this;
        }

        public UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public UserBuilder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public User build(){
            return new User(fName,lName,username,password,gender);
        }
    }
}
