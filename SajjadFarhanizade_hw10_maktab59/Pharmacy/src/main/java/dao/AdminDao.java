package dao;

import db_config.DbConfig;
import entity.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    public Admin login(String username, String password) throws SQLException {
        String query = "SELECT * FROM `admin` WHERE `username` = ? AND `password` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int id = rs.getInt("id");
            String fName = rs.getString("fName");
            String lName = rs.getString("lName");
            return new Admin(id, fName, lName, username, password);
        }
        return null;
    }

    public void add(Admin admin) throws SQLException {
        String query = "INSERT INTO `admin`(`fName`, `lName`, `username`, `password`) VALUES (?,?,?,?)";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1,admin.getfName());
        ps.setString(2,admin.getlName());
        ps.setString(3,admin.getUsername());
        ps.setString(4,admin.getPassword());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        admin.setId(rs.getInt(1));
    }
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM  `admin` WHERE `id`=?";
        query = "DELETE FROM  `admin` WHERE `id`=?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    public Admin getByID(int id) throws SQLException {
        String query = "SELECT * FROM `admin` WHERE `id`=?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String fName = rs.getString("fName");
        String lName = rs.getString("lName");
        String username = rs.getString("username");
        String password = rs.getString("password");
        return new Admin(id,fName,lName,username,password);
    }

    public void acceptPrescription(Prescription prescription, Admin admin) throws SQLException {
        String query = "DELETE FROM `prescriptionItem` where `prescription_id` = ?";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,prescription.getId());
        ps.executeUpdate();
        query = "INSERT INTO `prescriptionItem`(`prescription_id`, `item_id`, `doesExist`) VALUES (?,?,?)";
        ps = DbConfig.createDataSource().getConnection().prepareStatement(query);

        ps.setInt(1,prescription.getId());
        List<Item> items = prescription.getItems();
        int price = 0;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).isDoesExist())
                price+=items.get(i).getPrice();
            ps.setInt(2,items.get(i).getId());
            ps.setInt(3,(items.get(i).isDoesExist())?1:0);
            ps.executeUpdate();
        }
        query = "UPDATE `prescription` SET `admin_id`=? WHERE `id` = ?";
        ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,admin.getId());
        ps.setInt(2,prescription.getId());
        ps.executeUpdate();
        Factor factor =  new Factor(prescription.getDate(),prescription.getId(),price);
        query = "DELETE FROM `factor` WHERE `prescription_id` = ?";
        ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setInt(1,prescription.getId());
        ps.executeUpdate();
        query = "INSERT INTO `factor`(`date`, `prescription_id`, `price`) VALUES (?,?,?)";
        ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ps.setDate(1,factor.getDate());
        ps.setInt(2,factor.getPrescription_id());
        ps.setInt(3,factor.getPrice());
        ps.executeUpdate();
    }

    public Prescription checkPrescription(Prescription prescription, List<Item> items) throws SQLException {
        prescription.setItems(items);
        return prescription;
    }
}
