package dao;

import entity.Account;

import javax.persistence.EntityManager;

public class AccountDao extends BaseDao<Account,Long> {
    public AccountDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }
}
