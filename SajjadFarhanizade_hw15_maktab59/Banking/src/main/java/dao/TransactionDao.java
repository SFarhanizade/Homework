package dao;

import entity.Transaction;

import javax.persistence.EntityManager;

public class TransactionDao extends BaseDao<Transaction,Long> {
    public TransactionDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntityClass() {
        return Transaction.class;
    }
}
