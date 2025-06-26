import java.util.*;

class Course {
    String name;
    Professor professor;
    List<Student> students = new ArrayList<>();
    Course(String name) {
        this.name = name;
    }
    void assignProfessor(Professor p) {
        this.professor = p;
    }
    void enrollStudent(Student s) {
        students.add(s);
    }
}

class Professor {
    String name;
    Professor(String name) {
        this.name = name;
    }
}

class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
    void enrollCourse(Course c) {
        c.enrollStudent(this);
        System.out.println(name + " enrolled in " + c.name);
    }
}

public class University_Management_System {
    public static void main(String[] args) {
        Student s = new Student("Ankit");
        Professor p = new Professor("Dr. Rao");
        Course c = new Course("OOP");

        c.assignProfessor(p);
        s.enrollCourse(c);
    }
}
