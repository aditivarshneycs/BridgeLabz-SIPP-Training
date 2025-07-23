import java.util.*;

public class MultiLevelCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> exams = new Course<>();
        exams.addCourse(new ExamCourse("Math Exam"));

        Course<AssignmentCourse> assignments = new Course<>();
        assignments.addCourse(new AssignmentCourse("Java Assignment"));

        Course<ResearchCourse> research = new Course<>();
        research.addCourse(new ResearchCourse("AI Research"));

        System.out.println("--- Exam Courses ---");
        Course.printCourses(exams.getCourses());

        System.out.println("--- Assignment Courses ---");
        Course.printCourses(assignments.getCourses());

        System.out.println("--- Research Courses ---");
        Course.printCourses(research.getCourses());
    }
}

abstract class CourseType {
    String title;
    public CourseType(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public static void printCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c.getTitle());
        }
    }
}
