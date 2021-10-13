package dao;

import db_config.DbConfig;
import entity.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public List<Item> getItemsList() throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM `item`";
        PreparedStatement ps = DbConfig.createDataSource().getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            items.add(new Item(id,name,price,false));
        }
        return items;
    }
}
