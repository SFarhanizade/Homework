package manager;

import dao.CreditCardDao;
import entity.Account;
import entity.CreditCard;
import entity.Transaction;
import exception.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;

public class CreditCardManager extends BaseManager<CreditCard, Integer> {


    public CreditCardManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new CreditCardDao(entityManager));
    }

    public CreditCard loadByNumber(String number) {
        TypedQuery<CreditCard> query =
                entityManager.createQuery("From CreditCard c where c.number = :number", CreditCard.class);
        query.setParameter("number", number);
        return query.getSingleResult();
    }

    public boolean transferIsValid(String origin, String destination, Integer amount) throws CardNotExistsException, NotEnoughBalanceException, WrongAmountException {
        if(origin.length()!=16 || destination.length()!=16)
            throw new IllegalArgumentException("Card number length should be 16!");
        if(amount<=0)
            throw new WrongAmountException("The amount should be more than 0!");
        CreditCard originCreditCard = loadByNumber(origin);
        if (originCreditCard == null)
            throw new CardNotExistsException("Origin card number doesn't exist!");
        CreditCard destCreditCard = loadByNumber(destination);
        if (destCreditCard == null)
            throw new CardNotExistsException("Destination card number doesn't exist!");
        boolean hasMoney = originCreditCard.getAccount().getBalance() >= amount+600;
        if (originCreditCard.getAccount().getBalance() < amount)
            throw new NotEnoughBalanceException("Not enough balance!");
        return true;

    }

    public void transfer(CreditCard origin, String destination, Integer amount) {
        Account originAccount = origin.getAccount();
        originAccount.setBalance(originAccount.getBalance() - (amount + 600));
        Account destAccount = loadByNumber(destination).getAccount();
        destAccount.setBalance(destAccount.getBalance() + amount);
        Transaction transaction = Transaction.builder()
                .origin(originAccount)
                .destination(destAccount)
                .amount(amount)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        new TransactionManager(entityManager).save(transaction);
        new AccountManager(entityManager).save(originAccount);
        new AccountManager(entityManager).save(destAccount);
    }

    public void changePassword(CreditCard card, String newPassword) throws WrongExpDateException,
            WrongPasswordException, CardNotExistsException, AccountIsLockedException {
        if (cardIsValid(card)) {
            if (newPassword.length() != 4)
                throw new WrongPasswordException("Password length should be 4!");
            card.setPin(newPassword);
            update(card);
        }
    }

    public boolean cardIsValid(CreditCard creditCard) throws CardNotExistsException, WrongPasswordException,
            WrongExpDateException, AccountIsLockedException {
        CreditCard card = loadByNumber(creditCard.getNumber());
        if (card == null)
            throw new CardNotExistsException("Card doesn't exist!");
        if(card.getAccount().isLocked())
            throw new AccountIsLockedException("Account is locked!");
        if (creditCard.getPin() != card.getPin()) {
            if (card.getCountWrongPin() < 2) {
                card.setCountWrongPin(card.getCountWrongPin() + 1);
            } else {
                card.setCountWrongPin(3);
                card.getAccount().setLocked(true);
                save(card);
            }
            throw new WrongPasswordException("Wrong password!");
        }
        if (creditCard.getCvv() != card.getCvv())
            throw new WrongPasswordException("Wrong cvv!");
        if (creditCard.getExpDate() != card.getExpDate())
            throw new WrongExpDateException("Wrong Expiry date!");
        return true;
    }
}
