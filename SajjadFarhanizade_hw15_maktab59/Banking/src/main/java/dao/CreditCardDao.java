package dao;

import entity.CreditCard;
import exception.AccountIsLockedException;
import exception.WrongPasswordException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CreditCardDao extends BaseDao<CreditCard, Integer> {
    public CreditCardDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(CreditCard entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entity.setNumber(entity.getId() + 6037_0000_0000_0000L + "");
        update(entity);
    }

    public CreditCard login(String number, String pin) throws WrongPasswordException, AccountIsLockedException {
        entityManager.getTransaction().begin();
        TypedQuery<CreditCard> query = entityManager.createQuery(
                "From CreditCard c where c.number=:number", getEntityClass());
        query.setParameter("number", number);
        List<CreditCard> result = query.getResultList();
        if (result == null)
            return null;
        CreditCard card = result.get(0);
        if (card.getPin().equals(pin)) {
            if (!card.getAccount().isLocked()) {
                entityManager.getTransaction().commit();
                return card;
            }
            entityManager.getTransaction().commit();
            throw new AccountIsLockedException("The account is locked!");
        }
        card.enterWringPin();
        entityManager.merge(card);
        entityManager.getTransaction().commit();
        throw new WrongPasswordException("The pin is not correct!");
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
