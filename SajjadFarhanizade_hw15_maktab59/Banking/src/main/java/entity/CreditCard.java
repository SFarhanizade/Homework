package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity

public class CreditCard implements  BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer id;

    @Column(name = "card_number")
    private String number;

    @Column(name = "card_cvv")
    private String cvv;

    @Column(name = "card_pin")
    private String pin;

    @Column(name = "card_expDate")
    private String expDate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "card_wrongPin")
    private Integer countWrongPin;



    public CreditCard(String number,String cvv, String pin, String expDate, Account account) {
        this.number = number;
        this.cvv = cvv;
        this.pin = pin;
        this.expDate = expDate;
        this.account = account;
    }

    public CreditCard() {

    }

    public Integer getCountWrongPin() {
        return countWrongPin;
    }

    public void setCountWrongPin(Integer countWrongPin) {
        this.countWrongPin = countWrongPin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void setId(Integer s) {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static CreditCardBuilder builder(){
        return new CreditCardBuilder();
    }

    public static class CreditCardBuilder{
        private String number;
        private String cvv;
        private String pin;
        private String expDate;
        private Account account;

        public CreditCardBuilder number(String number) {
            this.number = number;
            return this;
        }

        public CreditCardBuilder cvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public CreditCardBuilder pin(String pin) {
            this.pin = pin;
            return this;
        }

        public CreditCardBuilder expDate(String expDate) {
            this.expDate = expDate;
            return this;
        }

        public CreditCardBuilder account(Account account) {
            this.account = account;
            return this;
        }

        public CreditCard build() {
            return new CreditCard(number,cvv,pin,expDate,account);
        }
    }

}
