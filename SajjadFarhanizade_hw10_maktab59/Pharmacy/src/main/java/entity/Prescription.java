package entity;

import java.sql.Date;

public class Prescription {
    private int id;
    private Date date;
    private int patient_id;
    private int admin_id;

    public Prescription(int id, Date date, int patient_id, int admin_id) {
        this.id = id;
        this.date = date;
        this.patient_id = patient_id;
        this.admin_id = admin_id;
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
