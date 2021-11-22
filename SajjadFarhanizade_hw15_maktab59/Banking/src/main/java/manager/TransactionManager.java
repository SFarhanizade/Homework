package manager;

import dao.TransactionDao;
import entity.Account;
import entity.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionManager extends BaseManager<Transaction, Long> {

    public TransactionManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new TransactionDao(entityManager));
    }

    public List<Transaction> getTransactions(Account account) {
        TypedQuery<Transaction> query = entityManager.createQuery("From Transaction t where t.origin=:account OR t.destination=:account",
                Transaction.class);
        query.setParameter("account", account);
        return query.getResultList();
    }
    public List<Transaction> getTransactionsAfter(Account account, Timestamp timestamp) {
        TypedQuery<Transaction> query = entityManager.createQuery(
                "From Transaction t where (t.origin=:account OR t.destination=:account)" +
                        "And t.timestamp >= :timestamp",
                Transaction.class);
        query.setParameter("account", account);
        query.setParameter("timestamp", timestamp);
        return query.getResultList();
    }


}
