package ir.maktab.jdbc.dao;

import ir.maktab.jdbc.config.DataSourceConfig;
import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.Course;
import ir.maktab.jdbc.exception.DataNotFoundException;
import ir.maktab.jdbc.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseDao implements BaseDao<Course, Integer> {

    private final DataSourceConfig dataSourceConfig = DataSourceConfig.getInstance();
    private Connection connection;

    @Override
    public void save(Course entity) {
        try {
            connection = dataSourceConfig.createDataSource().getConnection();
            try (
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Course " +
                            "(name,unit)" +
                            "VALUES(?,?)");) {
                ps.setString(1, entity.getName());
                ps.setInt(2, entity.getUnit());
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
    public void update(Integer id, Course newEntity) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE Course " +
                     "SET name=?, unit=?" +
                     "WHERE id=" + id);) {
            ps.setString(1, newEntity.getName());
            ps.setInt(2, newEntity.getUnit());
            ps.setInt(3, newEntity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Course " +
                     "WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public Course loadById(Integer id) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * " +
                     "FROM Course WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery();) {
                Course course = null;
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int unit = resultSet.getInt("unit");
                    course = Course.builder()
                            .id(id)
                            .name(name)
                            .unit(unit)
                            .build();
                }
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }

    public Set<Course> loadStudentCoursesById(Integer id){
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT c.* " +
                     "FROM StudentCourse sc, Course c WHERE studentId = ? AND c.id = sc.courseId")) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery();) {
                Set<Course> courses = new HashSet<>();
                Course course = null;
                while (resultSet.next()) {
                    int cId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int units = resultSet.getInt("unit");
                    course = Course.builder()
                            .id(cId)
                            .name(name)
                            .unit(units)
                            .build();
                    courses.add(course);
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }

    @Override
    public List<Course> loadAll() {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT *" +
                     " FROM Course");
             ResultSet resultSet = ps.executeQuery();) {

            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int unit = resultSet.getInt("unit");
                Course course = Course.builder()
                        .id(courseId)
                        .name(name)
                        .unit(unit)
                        .build();
                courses.add(course);
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }
}


