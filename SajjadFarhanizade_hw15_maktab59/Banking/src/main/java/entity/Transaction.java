package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Transaction implements BaseEntity<String>,Comparable<Transaction>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private String id;

    @Basic
    @Column(name = "transaction_dateTime", nullable = false)
    private Timestamp timestamp;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account origin;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account destination;

    @Column(name = "transaction_amount", nullable = false)
    Integer amount;

    public Transaction(Timestamp timestamp, Account origin, Account destination, Integer amount) {
        this.timestamp = timestamp;
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
    }

    public Transaction() {

    }

    @Override
    public void setId(String s) {

    }

    @Override
    public String getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }



    public static TransactionBuilder builder() {
        return new TransactionBuilder();
    }

    @Override
    public int compareTo(Transaction o) {
        long l1 = timestamp.getTime();
        long l2 = o.getTimestamp().getTime();
        return (int)(l2-l1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, origin, destination, amount);
    }

    public static class TransactionBuilder{
        private Timestamp timestamp;
        private Account origin;
        private Account destination;
        private Integer amount;

        public TransactionBuilder timestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public TransactionBuilder origin(Account origin) {
            this.origin = origin;
            return this;
        }

        public TransactionBuilder destination(Account destination) {
            this.destination = destination;
            return this;
        }

        public TransactionBuilder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Transaction build(){
            return new Transaction(timestamp,origin,destination,amount);
        }
    }
}
