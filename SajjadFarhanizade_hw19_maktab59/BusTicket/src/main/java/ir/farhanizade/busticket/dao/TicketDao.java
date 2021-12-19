package ir.farhanizade.busticket.dao;

import ir.farhanizade.busticket.core.BaseDao;
import ir.farhanizade.busticket.entity.Ticket;
import ir.farhanizade.busticket.entity.User;

import javax.persistence.EntityManager;

public class TicketDao extends BaseDao<Ticket> {
    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void saveOrUpdate(Ticket entity) {
        entityManager.getTransaction().begin();
        if (entity.getId() == null)
            entityManager.persist(entity);
        else
            entityManager.merge(entity);
        User owner = entity.getOwner();
        owner.addTicket(entity);
        entityManager.merge(owner);
        entityManager.getTransaction().commit();

    }

    @Override
    public void remove(Ticket entity) {
        entityManager.getTransaction().begin();
        entity.getOwner().getTickets().remove(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Integer id) {
        remove(loadById(id));
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
