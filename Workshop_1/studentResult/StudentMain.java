public class StudentMain {
    public static void main(String[] args) {
    int subjectCount = 3;

    Student s1 = new Student("vedanshu","123",3);
    Student s2 = new Student("harsh","125",3);
    Student s3 = new Student("rohan","128",3);

    s1.setSubjectGrade(0,87);
    s1.setSubjectGrade(1,67);
    s1.setSubjectGrade(2,80);


    s2.setSubjectGrade(0,87);
    s2.setSubjectGrade(1,67);
    s2.setSubjectGrade(2,90);


    s3.setSubjectGrade(0,65);
    s3.setSubjectGrade(1,35);
    s3.setSubjectGrade(2,89);

    Student[] studentArray = { s1, s2, s3 };
    GradeAnalyzer analyzer = new GradeAnalyzer(studentArray, subjectCount);

    analyzer.displayStudentReport();

    System.out.println();

    analyzer.displayClassAverage();

    }
}
