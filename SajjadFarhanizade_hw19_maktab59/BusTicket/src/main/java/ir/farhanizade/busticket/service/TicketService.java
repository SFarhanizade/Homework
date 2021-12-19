package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.TicketDao;
import ir.farhanizade.busticket.entity.Ticket;
import ir.farhanizade.busticket.entity.User;

import java.util.List;

public class TicketService extends BaseService<Ticket> {
    public TicketService() {
        baseDao = new TicketDao(entityManager);
    }

    public List<Ticket> getUserTickets(User user) {
        return ((TicketDao) baseDao).getUserTickets(user);
    }
}
