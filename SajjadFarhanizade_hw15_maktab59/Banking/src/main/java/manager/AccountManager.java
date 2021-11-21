package manager;

import dao.AccountDao;
import entity.Account;

import javax.persistence.EntityManager;

public class AccountManager extends BaseManager<Account,Long>{

    public AccountManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new AccountDao(entityManager));
    }


}
