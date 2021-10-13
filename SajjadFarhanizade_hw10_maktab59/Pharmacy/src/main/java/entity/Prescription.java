package entity;

import java.sql.Date;
import java.util.List;

public class Prescription {
    private int id;
    private Date date;
    private int patient_id;
    private int admin_id;
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public Prescription(int id, Date date, int patient_id, int admin_id, List<Item> items) {
        this.id = id;
        this.date = date;
        this.patient_id = patient_id;
        this.admin_id = admin_id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }
}
