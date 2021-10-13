package dao;

import db_config.DbConfig;
import entity.Admin;
import entity.Item;
import entity.Patient;
import entity.Prescription;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDao {

    public void createPrescription(Prescription prescription) throws SQLException {
        String query = "INSERT INTO `prescription`(`date`, `patient_id`) VALUES (?,?)";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setDate(1, prescription.getDate());
        ps.setInt(2, prescription.getPatient_id());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        prescription.setId(rs.getInt(1));
        addItemsToPrescription(prescription);
    }

    public void addItemsToPrescription(Prescription prescription) throws SQLException {
        String query = "INSERT INTO `prescriptionItem` (`prescription_id`,`item_id`,`doesExist`) VALUES(?,?,?)";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,prescription.getId());
        List<Item> items = prescription.getItems();
        for (int i = 0; i < items.size(); i++) {
            ps.setInt(2,items.get(i).getId());
            ps.setInt(3,(items.get(i).isDoesExist())?1:0);
            ps.executeUpdate();
        }
    }

    private List<Item> getPrescriptionItems(int id) throws SQLException {
        String query = "SELECT * FROM `prescriptionItem` WHERE `prescription_id`=?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1, id);
        List<Item> items = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        query = "SELECT * FROM `item` WHERE `id`=?";
        ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ResultSet tmpRs;
        while (rs.next()) {
            ps.setInt(1, rs.getInt("item_id"));
            tmpRs = ps.executeQuery();
            tmpRs.next();
            int itemID = tmpRs.getInt("id");
            String name = tmpRs.getString("name");
            int price = tmpRs.getInt("price");
            items.add(new Item(itemID, name, price, false));
        }
        return items;

    }

    public List<Prescription> getPrescriptions(int s) throws SQLException {
        List<Prescription> prescriptions = new ArrayList<>();
        //String query = "UPDATE `prescription` SET `admin_id`=? WHERE `id`=?";
        String query="";
        if(s==0)
        query = "SELECT * FROM `prescription` WHERE `admin_id` IS NULL";
        else
            query = "SELECT * FROM `prescription`";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            Date date = rs.getDate("date");
            int patientID = rs.getInt("patient_id");
            List<Item> items = getPrescriptionItems(id);
            Prescription prescription = new Prescription(id, date, patientID, 0, getPrescriptionItems(id));
            prescription.setItems(items);
            prescriptions.add(prescription);
        }
        return prescriptions;
    }

    public List<Prescription> getNotAcceptedPrescriptions(Patient patient) throws SQLException {
        List<Prescription> prescriptions = new ArrayList<>();
        //String query = "UPDATE `prescription` SET `admin_id`=? WHERE `id`=?";
        String query = "SELECT * FROM `prescription` WHERE `admin_id` IS NULL AND `patient_id` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,patient.getId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            Date date = rs.getDate("date");
            prescriptions.add(new Prescription(id, date, patient.getId(), 0, getPrescriptionItems(id)));
        }
        return prescriptions;
    }

    public int getFactor(Prescription prescription) throws SQLException {
        String query = "SELECT * FROM `factor` WHERE `prescription_id` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,prescription.getId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt("price");
        }
        return -1;
    }

    public void updateNotAcceptedPrescriptions(Prescription prescription) throws SQLException {
        String query = "DELETE FROM `prescriptionItem` WHERE `prescription_id` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,prescription.getId());
        ps.executeUpdate();
        addItemsToPrescription(prescription);
    }

    public List<Prescription> getAcceptedPrescriptions(int patientID) throws SQLException {
        List<Prescription> prescriptions = new ArrayList<>();
        String query = "SELECT * FROM `prescription` WHERE `admin_id` IS NOT NULL AND `patient_id` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,patientID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            Date date = rs.getDate("date");
            int adminID = rs.getInt("admin_id");
            prescriptions.add(new Prescription(id, date, patientID, adminID, getPrescriptionItems(id)));
        }
        return prescriptions;
    }

    public void delete(Prescription prescription) throws SQLException {
        String query = "DELETE FROM `prescription` WHERE `id` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,prescription.getId());
        ps.executeUpdate();
    }

}
