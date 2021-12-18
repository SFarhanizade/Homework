package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.TicketDao;
import ir.farhanizade.busticket.entity.Ticket;

public class TicketService extends BaseService<Ticket> {
    public TicketService() {
        baseDao = new TicketDao(entityManager);
    }
}
