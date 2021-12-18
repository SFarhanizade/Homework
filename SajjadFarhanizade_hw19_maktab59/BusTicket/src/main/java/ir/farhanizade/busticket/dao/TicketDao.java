package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.Ticket;

import javax.persistence.EntityManager;

public class TicketDao extends BaseDao<Ticket> {
    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
