package entity;

import java.sql.Date;

public class Factor {
    private int id;
    private Date date;
    private int prescription_id;
    private int price;

    public Factor(int id, Date date, int prescription_id, int price) {
        this.id = id;
        this.date = date;
        this.prescription_id = prescription_id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public int getPrice() {
        return price;
    }
}
