import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    private static DbConnection dbConnection = new DbConnection();
    private static Statement statement;

    static {
        try {
            statement = dbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) throws SQLException {
        loadDataBase();
        Menu.main(args);
    }

    public static void printStudents() {
        System.out.println("Students:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getId() + "- " + student.getfName() + " " + student.getlName());
        }
    }

    public static void printTeacher() {
        System.out.println("Teachers:");
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            System.out.println(teacher.getId() + "- " + teacher.getfName() + " " + teacher.getlName());
        }
    }

    public static void loadDataBase() throws SQLException {
        teachers.clear();
        students.clear();
        ResultSet resultset = statement.executeQuery("Select * From Student");
        while (resultset.next()) {
            students.add(new Student(resultset.getInt("id"), resultset.getString("fName"),
                    resultset.getString("lName")));
        }
        resultset = statement.executeQuery("Select * From Teacher");
        while (resultset.next()) {
            teachers.add(new Teacher(resultset.getInt("id"), resultset.getString("fName"),
                    resultset.getString("lName")));
        }
    }

    private static ArrayList<Student> getStudents(Teacher teacher) throws SQLException {
        ArrayList<Student> studentsList = new ArrayList<>();
        ResultSet resultset = statement.executeQuery(teacher.getStudents());
        while (resultset.next()) {
            studentsList.add(new Student(resultset.getInt("id"), resultset.getString("fName"),
                    resultset.getString("lName")));
        }
        return studentsList;
    }

    private static ArrayList<Teacher> getTeachers(Student student) throws SQLException {
        ArrayList<Teacher> teachersList = new ArrayList<>();
        ResultSet resultset = statement.executeQuery(student.getTeachers());
        while (resultset.next()) {
            teachersList.add(new Teacher(resultset.getInt("id"), resultset.getString("fName"),
                    resultset.getString("lName")));
        }
        return teachersList;
    }

    public static Student getStudentByID(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id)
                return students.get(i);
        }
        return null;
    }

    public static Teacher getTeacherByID(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id)
                return teachers.get(i);
        }
        return null;
    }

    public static void printStudentList(Teacher teacher) throws SQLException {
        System.out.println("Students Of " + teacher.getfName() + " " + teacher.getlName() + ":");
        ArrayList<Student> students = getStudents(teacher);
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getId() + "- " + student.getfName() + " " + student.getlName());
        }
    }

    public static void printTeacherList(Student student) throws SQLException {
        System.out.println("Teachers Of " + student.getfName() + " " + student.getlName() + ":");
        ArrayList<Teacher> teachers = getTeachers(student);
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            System.out.println(teacher.getId() + "- " + teacher.getfName() + " " + teacher.getlName());
        }
    }

    public static void queryUpdate(String QUERY) throws SQLException {
        statement.executeUpdate(QUERY);
        loadDataBase();
        System.out.println("Done!");
    }

    public static void removeStudent(int id) throws SQLException {
        int index = studentExists(id);
        if (index > -1) {
            queryUpdate(students.get(index).remove());
        }
        else
            System.out.println("There are no students with this ID!");
    }

    public static void removeTeacher(int id) throws SQLException {
        int index = teacherExists(id);
        if (index > -1) {
            queryUpdate(teachers.get(index).remove());
        }
    }

    public static int teacherExists(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public static int studentExists(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public static void addStudent(Student student) throws SQLException {
        if (studentExists(student.getId()) == -1) {
            String QUERY = "Insert Into Student Values(" + student.getId() + ",'" + student.getfName() + "','" + student.getlName() + "')";
            queryUpdate(QUERY);
        } else
            System.out.println("The student has already existed!");
    }

    public static void addTeacher(Teacher teacher) throws SQLException {
        if (teacherExists(teacher.getId()) == -1) {
            String QUERY = "Insert Into Teacher Values(" + teacher.getId() + ",'" + teacher.getfName() + "','" + teacher.getlName() + "')";
            queryUpdate(QUERY);
        }
    }
}