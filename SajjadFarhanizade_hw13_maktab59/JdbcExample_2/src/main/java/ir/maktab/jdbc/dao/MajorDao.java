package ir.maktab.jdbc.dao;

import ir.maktab.jdbc.config.DataSourceConfig;
import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.Major;
import ir.maktab.jdbc.exception.DataNotFoundException;
import ir.maktab.jdbc.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDao implements BaseDao<Major, Integer> {

    private final DataSourceConfig dataSourceConfig = DataSourceConfig.getInstance();
    private Connection connection;

    @Override
    public void save(Major entity) {
        try {
            connection = dataSourceConfig.createDataSource().getConnection();
            try (
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Major " +
                            "(name)" +
                            "VALUES(?)");) {
                ps.setString(1, entity.getName());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not insert data to db");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Integer id, Major newEntity) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE Major " +
                     "SET name=? " +
                     "WHERE id=" + id);){
            ps.setString(1, newEntity.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Major " +
                     "WHERE id=?")){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public Major loadById(Integer id) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * " +
                     "FROM Major WHERE id = ?")){
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery();) {
                Major major = null;
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    major = Major.builder()
                            .id(id)
                            .name(name)
                            .build();
                }
                return major;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }

    @Override
    public List<Major> loadAll() {try (Connection connection = dataSourceConfig.createDataSource().getConnection();
                                       PreparedStatement ps = connection.prepareStatement("SELECT *" +
                                               " FROM Major");
                                       ResultSet resultSet = ps.executeQuery();){

        List<Major> majors = new ArrayList<>();
        while (resultSet.next()) {
            int majorId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Major major = Major.builder()
                    .id(majorId)
                    .name(name)
                    .build();
            majors.add(major);
        }
        return majors;
    } catch (SQLException e) {
        e.printStackTrace();
        throw new DataNotFoundException("Can not find data from db");
    }
    }
}
