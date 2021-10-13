package dao;

import db_config.DbConfig;
import entity.Factor;
import entity.Patient;
import entity.Prescription;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    public Patient login(String username, String password) throws SQLException {
        String query = "SELECT * FROM `patient` WHERE `username` = ? AND `password` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int id = rs.getInt("id");
            String fName = rs.getString("fName");
            String lName = rs.getString("lName");
            return new Patient(id, fName, lName, username, password);
        }
        return null;
    }

    public List getPrescription(Patient patient) throws SQLException {
        List list = new ArrayList();
        List<Factor> factors = new ArrayList();
        List<Prescription> prescriptions = new PrescriptionDao().getAcceptedPrescriptions(patient.getId());

        for (int i = 0; i < prescriptions.size(); i++) {
            String query = "SELECT * FROM `factor` WHERE `prescription_id` = ?";
            PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
            ps.setInt(1, prescriptions.get(i).getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            Date fDate = rs.getDate("date");
            int price = rs.getInt("price");
            factors.add(new Factor(fDate, prescriptions.get(i).getId(), price));
        }

        list.add(prescriptions);
        list.add(factors);
        return list;
    }
}
