import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private static Scanner input = new Scanner(System.in);
    private static int menuNum;
    public static void main(String[] args) throws SQLException {
        while (true){
            System.out.println("1-Students");
            System.out.println("2-Teachers");
            menuNum=input.nextInt();
            switch (menuNum){
                case 1:{
                    A: while(true) {
                        System.out.println("1-Show List");
                        System.out.println("2-Add a new Student");
                        System.out.println("3-Remove a Student");
                        System.out.println("4-Back");
                        menuNum = input.nextInt();
                        input.nextLine();
                        switch (menuNum) {
                            case 1: {
                                Main.printStudents();
                                System.out.println("\nEnter the student ID (0 to back):");
                                menuNum = input.nextInt();
                                if(menuNum==0)
                                    break;
                                else {
                                    Student student = Main.getStudentByID(menuNum);
                                    B: while (true) {
                                        System.out.println("Student: " + student.getfName() + " " + student.getlName());
                                        System.out.println("1-Change the Name");
                                        System.out.println("2-Show Teachers");
                                        System.out.println("3-Remove the student");
                                        System.out.println("4-Back");
                                        menuNum = input.nextInt();
                                        input.nextLine();
                                        switch (menuNum) {
                                            case 1: {
                                                System.out.println("Enter the first name (N to skip):");
                                                String fName = input.nextLine();
                                                System.out.println("Enter the last name (N to skip):");
                                                String lName = input.nextLine();
                                                if (!(fName.length() == 1 && fName.startsWith("N"))) {
                                                    Main.queryUpdate(student.setfName(fName));
                                                }
                                                if (!(lName.length() == 1 && lName.startsWith("N"))) {
                                                    Main.queryUpdate(student.setlName(lName));
                                                }
                                                break;
                                            }
                                            case 2: {
                                                C:
                                                while (true) {
                                                    Main.printTeacherList(student);
                                                    System.out.println("1-Remove a teacher");
                                                    System.out.println("2-Add a teacher");
                                                    System.out.println("3-Back");
                                                    menuNum = input.nextInt();
                                                    input.nextLine();
                                                    switch (menuNum) {
                                                        case 1: {
                                                            System.out.println("Enter the teacher ID:");
                                                            menuNum = input.nextInt();
                                                            if (Main.teacherExists(menuNum) > -1)
                                                                Main.queryUpdate(student.removeTeacher(menuNum));
                                                            else
                                                                System.out.println("There are no teachers with this ID!");
                                                            break;
                                                        }
                                                        case 2: {
                                                            System.out.println("Enter the teacher ID:");
                                                            menuNum = input.nextInt();
                                                            if (Main.teacherExists(menuNum) > -1)
                                                                Main.queryUpdate(student.addTeacher(menuNum));
                                                            else
                                                                System.out.println("There are no teachers with this ID!");
                                                            break;
                                                        }
                                                        case 3: {
                                                            break C;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            case 3: {
                                                Main.removeStudent(student.getId());
                                                break B;
                                            }
                                            case 4: {
                                                break B;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Enter an ID: ");
                                int id = input.nextInt();
                                input.nextLine();
                                System.out.println("Enter the first name:");
                                String fName = input.nextLine();
                                System.out.println("Enter the last name:");
                                String lName = input.nextLine();
                                Main.addStudent(new Student(id,fName,lName));
                                break;
                            }
                            case 3: {
                                System.out.println("Enter the student ID:");
                                Main.removeStudent(input.nextInt());
                                input.nextLine();
                                break;
                            }
                            case 4: {
                                break A;
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    A: while(true) {
                    System.out.println("1-Show List");
                    System.out.println("2-Add a new Teacher");
                    System.out.println("3-Remove a Teacher");
                    System.out.println("4-Back");
                    menuNum = input.nextInt();
                    switch (menuNum) {
                        case 1: {
                            Main.printTeacher();
                            System.out.println("\nEnter the teacher ID (0 to back):");
                            menuNum = input.nextInt();
                            input.nextLine();
                            if(menuNum==0)
                                break;
                            else {
                                Teacher teacher = Main.getTeacherByID(menuNum);
                                B:
                                while (true) {
                                    System.out.println("Teacher: " + teacher.getfName() + " " + teacher.getlName());
                                    System.out.println("1-Change the Name");
                                    System.out.println("2-Show Students");
                                    System.out.println("3-Remove the teacher");
                                    System.out.println("4-Back");
                                    menuNum = input.nextInt();
                                    input.nextLine();
                                    switch (menuNum) {
                                        case 1: {
                                            System.out.println("Enter the first name (N to skip):");
                                            String fName = input.nextLine();
                                            System.out.println("Enter the last name (N to skip):");
                                            String lName = input.nextLine();
                                            if (!(fName.length() == 1 && fName.startsWith("N"))) {
                                                Main.queryUpdate(teacher.setfName(fName));
                                            }
                                            if (!(lName.length() == 1 && lName.startsWith("N"))) {
                                                Main.queryUpdate(teacher.setlName(lName));
                                            }
                                            break;
                                        }
                                        case 2: {
                                            C:
                                            while (true) {
                                                Main.printStudentList(teacher);
                                                System.out.println("1-Remove a student");
                                                System.out.println("2-Add a student");
                                                System.out.println("3-Back");
                                                menuNum = input.nextInt();
                                                input.nextLine();
                                                switch (menuNum) {
                                                    case 1: {
                                                        System.out.println("Enter the student ID:");
                                                        menuNum = input.nextInt();
                                                        input.nextLine();
                                                        if (Main.studentExists(menuNum) > -1)
                                                            Main.queryUpdate(teacher.removeStudent(menuNum));
                                                        else
                                                            System.out.println("There are no students with this ID!");
                                                        break;
                                                    }
                                                    case 2: {
                                                        System.out.println("Enter the student ID:");
                                                        menuNum = input.nextInt();
                                                        input.nextLine();
                                                        if (Main.studentExists(menuNum) > -1)
                                                            Main.queryUpdate(teacher.addStudent(menuNum));
                                                        else
                                                            System.out.println("There are no students with this ID!");
                                                        break;
                                                    }
                                                    case 3: {
                                                        break C;
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 3: {
                                            Main.removeTeacher(teacher.getId());
                                            break B;
                                        }
                                        case 4: {
                                            break B;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Enter an ID: ");
                            int id = input.nextInt();
                            input.nextLine();
                            System.out.println("Enter the first name:");
                            String fName = input.nextLine();
                            System.out.println("Enter the last name:");
                            String lName = input.nextLine();
                            Main.addTeacher(new Teacher(id,fName,lName));
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the teacher ID:");
                            Main.removeTeacher(input.nextInt());
                            input.nextLine();
                            break;
                        }
                        case 4: {
                            break A;
                        }
                    }
                }
                    break;
                }
            }
        }
    }
}
