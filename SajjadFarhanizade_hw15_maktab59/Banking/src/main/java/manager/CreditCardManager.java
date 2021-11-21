package manager;

import dao.CreditCardDao;
import entity.CreditCard;

import javax.persistence.EntityManager;

public class CreditCardManager extends BaseManager<CreditCard,Long>{

    public CreditCardManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new CreditCardDao(entityManager));
    }
}
