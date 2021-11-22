package manager;

import dao.CreditCardDao;
import entity.Account;
import entity.CreditCard;
import entity.Transaction;
import exception.CardNotExistsException;
import exception.NotEnoughBalanceException;
import exception.WrongExpDateException;
import exception.WrongPasswordException;

import javax.persistence.EntityManager;
import java.sql.Timestamp;

public class CreditCardManager extends BaseManager<CreditCard,Long>{

    public CreditCardManager(EntityManager entityManager) {
        super(entityManager);
        setBaseDao(new CreditCardDao(entityManager));
    }

    public boolean transferIsValid(Long origin, Long destination, Integer amount) throws CardNotExistsException, NotEnoughBalanceException {
        CreditCard originCreditCard = loadById(origin);
        if(originCreditCard==null)
            throw new CardNotExistsException("Origin card number doesn't exist!");
        CreditCard destCreditCard = loadById(destination);
        if(destCreditCard==null)
            throw new CardNotExistsException("Destination card number doesn't exist!");
        boolean hasMoney = originCreditCard.getAccount().getBalance()>=amount;
        if(originCreditCard.getAccount().getBalance()<amount)
            throw new NotEnoughBalanceException("Not enough balance!");
        return true;

    }

    public void transfer(CreditCard origin, Long destination, Integer amount){
        Account originAccount = origin.getAccount();
        originAccount.setBalance(originAccount.getBalance()-(amount+600));
        Account destAccount = loadById(destination).getAccount();
        destAccount.setBalance(destAccount.getBalance()+amount);
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

    public void changePassword(CreditCard card, String newPassword) throws WrongExpDateException, WrongPasswordException, CardNotExistsException {
            if(cardIsValid(card)) {
                if(newPassword.length()!=4)
                    throw new WrongPasswordException("Password length should be 4!");
                card.setPin(newPassword);
                update(card);
            }
    }

    public boolean cardIsValid(CreditCard creditCard) throws CardNotExistsException, WrongPasswordException, WrongExpDateException {
        CreditCard card = loadById(creditCard.getId());
        if(card==null)
            throw new CardNotExistsException("Card doesn't exist!");
        if(creditCard.getPin()!=card.getPin())
            throw new WrongPasswordException("Wrong password!");
        if (creditCard.getCvv()!=card.getCvv())
            throw new WrongPasswordException("Wrong cvv!");
        if(creditCard.getExpDate()!=card.getExpDate())
            throw new WrongExpDateException("Wrong Expiry date!");
        return true;
    }
}
