package manager;

import dao.TransactionDao;
import entity.Transaction;

import javax.persistence.EntityManager;

public class TransactionManager extends BaseManager<Transaction,Long>{

    public TransactionManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new TransactionDao(entityManager));
    }
}
