package manager;

import dao.AccountDao;
import entity.Account;
import entity.CreditCard;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountManager extends BaseManager<Account,Long>{

    public AccountManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new AccountDao(entityManager));
    }

    public CreditCard getCreditCard(Account account){
        Query query = entityManager.createQuery("From CreditCard c where c.account = :account",CreditCard.class);
        query.setParameter("account",account);
        List resultList = query.getResultList();
        if(resultList.size()==1)
        return (CreditCard) resultList.get(0);
        return null;
    }

    public Set<Account> getAccounts(Customer customer){
        TypedQuery<Account> query = entityManager.createQuery("From Account a where a.customer = :customer", Account.class);
        query.setParameter("customer", customer);
        return new HashSet<>(query.getResultList());
    }


}
