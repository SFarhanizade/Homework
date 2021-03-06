package ir.maktab.jdbc.dao;

import ir.maktab.jdbc.config.DataSourceConfig;
import ir.maktab.jdbc.dao.core.BaseDao;
import ir.maktab.jdbc.entity.Course;
import ir.maktab.jdbc.entity.Major;
import ir.maktab.jdbc.entity.Student;
import ir.maktab.jdbc.exception.DataNotFoundException;
import ir.maktab.jdbc.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class StudentDao implements BaseDao<Student, Integer> {

    private final DataSourceConfig dataSourceConfig = DataSourceConfig.getInstance();
    private Connection connection;

    @Override
    public void save(Student entity) {
        try {
            connection = dataSourceConfig.createDataSource().getConnection();
            try (
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Student " +
                            "(name, familyName, majorId) " +
                            "VALUES(?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);) {
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getFamilyName());
                ps.setInt(3, entity.getMajor().getId());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                try (PreparedStatement psCourse= connection.prepareStatement("Insert Into StudentCourse (studentId, courseId) " +
                        "Values(" + id + ",?)")) {
                    for (Course course : entity.getCourses()){
                        psCourse.setInt(1,course.getId());
                        psCourse.executeUpdate();
                    }
                }
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
    public void update(Integer id, Student newEntity) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();){
            PreparedStatement ps = connection.prepareStatement("UPDATE Student " +
                    "SET name=?, familyName=?, majorId=? " +
                    "WHERE id=" + id);
            ps.setString(1, newEntity.getName());
            ps.setString(2, newEntity.getFamilyName());
            ps.setInt(3, newEntity.getMajor().getId());
            ps.executeUpdate();
            ps = connection.prepareStatement("Delete From StudentCourse WHERE studentId=" + id);
            ps.executeUpdate();
            ps = connection.prepareStatement("Insert Into StudentCourse (studentId, courseId) " +
                    "Values("+id+",?)");
            for (Course course : newEntity.getCourses()){
                ps.setInt(1,course.getId());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM Student " +
                     "WHERE id=?")){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public Student loadById(Integer id) {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT s.*, m.* " +
                     "FROM Student s, Major m WHERE s.id = ? AND s.majorId = m.id")){
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery();) {
                Student student = null;
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String familyName = resultSet.getString("familyName");
                    int majorId = resultSet.getInt("majorId");
                    Set<Course> courses = new CourseDao().loadStudentCoursesById(id);
                    student = Student.builder()
                            .id(studentId)
                            .name(name)
                            .familyName(familyName)
                            .major(new MajorDao().loadMajorByStudentId(majorId))
                            .courses(courses)
                            .build();
                }
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }

    @Override
    public List<Student> loadAll() {
        try (Connection connection = dataSourceConfig.createDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM Student");
             ResultSet resultSet = ps.executeQuery();){

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String familyName = resultSet.getString("familyName");
                int majorId = resultSet.getInt("majorId");
                Set<Course> courses = new CourseDao().loadStudentCoursesById(studentId);
                Student student = Student.builder()
                        .id(studentId)
                        .name(name)
                        .familyName(familyName)
                        .major(new MajorDao().loadMajorByStudentId(majorId))
                        .courses(courses)
                        .build();
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data from db");
        }
    }

    public void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        connection.commit();
    }
}
