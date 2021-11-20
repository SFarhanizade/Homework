package entity;

import javax.persistence.*;

@Entity
public class CreditCard implements  BaseEntity<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_number",length = 16)
    private String number;

    @Column(name = "card_cvv")
    private String cvv;

    @Column(name = "card_pin")
    private String pin;

    @Column(name = "card_expDate")
    private String expDate;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    public CreditCard(String cvv, String pin, String expDate) {
        this.cvv = cvv;
        this.pin = pin;
        this.expDate = expDate;
    }

    public CreditCard() {

    }

    @Override
    public void setId(String s) {

    }

    @Override
    public String getId() {
        return number;
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
}
