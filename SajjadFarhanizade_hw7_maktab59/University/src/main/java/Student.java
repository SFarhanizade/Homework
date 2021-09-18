import javax.management.Query;
import java.util.ArrayList;

public class Student {
    private final int id;
    private String fName;
    private String lName;
    private String QUERY;
    public Student(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }


    public String getfName() {
        return fName;
    }

    public String setfName(String fName) {
        QUERY = "Update Student SET fName = '"+fName+"' Where fName = '"+this.fName+"'";
        this.fName = fName;
        return QUERY;
    }

    public String getlName() {
        return lName;
    }

    public String getTeachers(){
        QUERY = "SELECT t.* FROM Student s, Teacher t, StudentTeacherList l WHERE l.student_id = s.id AND t.id = l.teacher_id AND s.id="+id;
        return QUERY;
    }

    public String removeTeacher(int id){
        QUERY = "DELETE FROM `StudentTeacherList` WHERE student_id="+this.id+" And teacher_id="+id;
        return QUERY;
    }

    public String addTeacher(int id){
        QUERY = "INSERT INTO StudentTeacherList VALUES("+this.id+","+id+")";
        return QUERY;
    }

    public String remove(){
        QUERY = "Delete From Student Where id="+id;
        return QUERY;
    }

    public String setlName(String lName) {
        QUERY = "Update Student SET lName = '"+lName+"' Where lName = '"+this.lName+"'";
        this.lName = lName;
        return QUERY;
    }
}
