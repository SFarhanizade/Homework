public class Teacher {
    private final int id;
    private String fName;
    private String lName;
    private String QUERY;

    public Teacher(int id, String fName, String lName) {
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
        QUERY = "Update Teacher SET fName = '"+fName+"' Where fName = '"+this.fName+"'";
        this.fName = fName;
        return QUERY;
    }

    public String getlName() {
        return lName;
    }

    public String getStudents(){
        QUERY = "SELECT s.* FROM Student s, Teacher t, StudentTeacherList l WHERE l.student_id = s.id AND t.id = l.teacher_id AND t.id="+id;
        return QUERY;
    }

    public String removeStudent(int id){
        QUERY = "DELETE FROM `StudentTeacherList` WHERE student_id="+id+" And teacher_id="+this.id;
        return QUERY;
    }

    public String addStudent(int id){
        QUERY = "INSERT INTO StudentTeacherList VALUES("+id+","+this.id+")";
        return QUERY;
    }

    public String remove(){
        QUERY = "Delete From Teacher Where id="+id;
        return QUERY;
    }

    public String setlName(String lName) {
        QUERY = "Update Teacher SET lName = '"+lName+"' Where lName = '"+this.lName+"'";
        this.lName = lName;
        return QUERY;
    }
}
