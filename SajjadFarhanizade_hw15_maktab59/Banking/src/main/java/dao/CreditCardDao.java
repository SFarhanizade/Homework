package dao;

import entity.CreditCard;

import javax.persistence.EntityManager;

public class CreditCardDao extends BaseDao<CreditCard,Integer>{
    public CreditCardDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(CreditCard entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entity.setNumber(entity.getId()+6037_0000_0000_0000L+"");
        update(entity);
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
