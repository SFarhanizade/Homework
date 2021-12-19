package ir.farhanizade.busticket;

import ir.farhanizade.busticket.entity.*;
import ir.farhanizade.busticket.service.*;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {

        AdminService adminService = new AdminService();
        Admin admin = new Admin("Admin", "admin", "admin");
        adminService.saveOrUpdate(admin);

        CityService cityService = new CityService();
        City city1 = new City("Mashhad");
        cityService.saveOrUpdate(city1);
        City city2 = new City("Tehran");
        cityService.saveOrUpdate(city2);

        long l = System.currentTimeMillis();
        System.out.println(l);
        TravelService travelService = new TravelService();
        Travel travel = Travel.builder()
                .origin(city1)
                .destination(city2)
                .date(java.time.LocalDate.now())
                .time(new Time(System.currentTimeMillis()))
                .build();
        travelService.saveOrUpdate(travel);

        UserService userService = new UserService();
        User user = User.builder()
                .fName("Sajjad")
                .lName("Farhanizade")
                .username("SFarhanizade")
                .password("1234")
                .gender(Gender.MALE)
                .build();
        userService.saveOrUpdate(user);

        TicketService ticketService = new TicketService();
        Ticket ticket = Ticket.builder()
                .travel(travel)
                .owner(user)
                .build();
        ticketService.saveOrUpdate(ticket);
    }
}
