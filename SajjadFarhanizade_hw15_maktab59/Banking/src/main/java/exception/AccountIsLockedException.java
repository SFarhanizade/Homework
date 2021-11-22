package exception;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
