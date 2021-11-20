package dao;

import entity.CreditCard;

import javax.persistence.EntityManager;

public class CreditCardDao extends BaseDao<CreditCard,String>{
    public CreditCardDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
