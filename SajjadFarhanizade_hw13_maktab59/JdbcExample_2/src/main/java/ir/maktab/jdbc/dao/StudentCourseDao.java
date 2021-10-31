package ir.maktab.jdbc.dao;

import ir.maktab.jdbc.config.DataSourceConfig;
import ir.maktab.jdbc.entity.Course;
import ir.maktab.jdbc.entity.Student;
import ir.maktab.jdbc.entity.StudentCourse;
import ir.maktab.jdbc.exception.DataNotFoundException;
import ir.maktab.jdbc.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDao {
    private final DataSourceConfig dataSourceConfig = DataSourceConfig.getInstance();
    private Connection connection;

    public void save(StudentCourse entity) {
        try {
            connection = dataSourceConfig.createDataSource().getConnection();
            try (
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO StudentCourse " +
                            "(studentId,courseId)" +
                            "VALUES(?,?)");) {
                ps.setInt(1, entity.getStudent().getId());
                ps.setInt(2, entity.getCourse().getId());
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


    public void delete(StudentCourse entity) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM StudentCourse " +
                     "WHERE studentId=? AND courseId=?")) {
            ps.setInt(1, entity.getStudent().getId());
            ps.setInt(2, entity.getCourse().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    public List<Course> loadById(Integer integer) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT c.* " +
                     "FROM Course c, StudentCourse sc WHERE sc.studentId=?")) {
            ps.setInt(1, integer);
            try (ResultSet resultSet = ps.executeQuery();) {
                List<Course> courses = new ArrayList<>();
                Course course = null;
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int id = resultSet.getInt("id");
                    int unit = resultSet.getInt("unit");
                    course = Course.builder()
                            .id(id)
                            .name(name)
                            .unit(unit)
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

    public List<StudentCourse> loadAll() {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT *" +
                     " FROM StudentCourse");
             ResultSet resultSet = ps.executeQuery();) {

            List<StudentCourse> studentCourses = new ArrayList<>();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("id");
                int studentId = resultSet.getInt("id");
                StudentCourse studentCourse = StudentCourse.builder()
                        .student(Student.builder().id(studentId).build())
                        .course(Course.builder().id(courseId).build())
                        .build();
                studentCourses.add(studentCourse);
            }
            return studentCourses;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }
}

