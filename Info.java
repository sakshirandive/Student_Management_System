
import java.util.*;

class Student {

    int id;
    String name;
    String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;

    }

    public int getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public String getCourse() {

        return course;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setCourse(String course) {

        this.course = course;
    }

    public String toString() {
        return id + " " + name + " " + course;
    }
}

class Management {

    List<Student> li = new ArrayList<Student>();

    public void studentAdd(int id, String name, String course) {

        Student s = new Student(id, name, course);
        li.add(s);
        System.out.println("student added succesfully");

    }

    public void displayStudent(int id) {
        for (Student student : li) {
            if (student.getId() == id) {
                
                System.out.println("id : "+"  " + student.getId() +"  "+ "name :"+"  " + student.getName() + "  "+"course :" +"  "+ student.getCourse());
            }
            System.out.println(student);
        }

    }

    public void deleteStudent(int id) {
        li.removeIf(s -> s.getId() == id);

    }

    public void updateStudent(int id, String newName, String newCourse) {
        for (Student s : li) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setCourse(newCourse);

            }
        }
    }

}

public class Info {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management mg = new Management();

        while (true) {
            System.out.println("enter 1 create student data" + '\n' + "enter 2 to delete student data" + '\n' + "enter 3 to dispaly student data" + '\n' + "enter 4 to update student data" + '\n' + "enter 5 to exit");
            System.out.println("enter ur choice");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    System.out.println("enter student id");
                    int newId = sc.nextInt();
                    System.out.println("enter student name");
                    sc.nextLine();
                    String newName = sc.nextLine();
                    System.out.println("enter student course");
                    String newCourse = sc.nextLine();
                    mg.studentAdd(newId, newName, newCourse);
                    break;
                case 2:
                    System.out.println("enter student id to delete");
                    int deleteId = sc.nextInt();
                    mg.deleteStudent(deleteId);
                    System.out.println("student delete succesfully");
                    break;

                case 3:
                    System.out.println("enter student id");
                    int dispId = sc.nextInt();
                    mg.displayStudent(dispId);
                    break;

                case 4:
                    System.out.println("enter student id to update");
                    int nid = sc.nextInt();
                    String nename = sc.nextLine();
                    String nCourse = sc.nextLine();
                    mg.updateStudent(nid, nename, nCourse);
                    mg.displayStudent(nid);

                case 5:
                    System.out.println("program is terminated");
                    return;

                default:
                    System.out.println("invalid choice");

            }

        }
    }
}
