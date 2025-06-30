public class GradeAnalyzer {
    private  Student[] students;

    private int subjectCount;

    public GradeAnalyzer(Student[] students, int subjectCount) {
        this.students = students;
        this.subjectCount = subjectCount;
    }

    public int[] getHighestGradeSubject(){
        int[] highest = new int[subjectCount];
        for (int i = 0; i < subjectCount;  i++) {
            highest[i] = -1;
            for(Student student : students){
                Integer[] subjectGrades = student.getSubjectGrade();
                if (subjectGrades[i] != null && subjectGrades[i] > highest[i]) {
                    highest[i] = subjectGrades[i];
                }

            }
        }
        return highest;
    }

    public double getClassAverage() {
        int total = 0, count = 0;
        for (Student student : students) {
            for (Integer g : student.getSubjectGrade()) {
                if (g != null) {
                    total += g;
                    count++;
                }
            }
        }
        return (count > 0) ? (double) total / count : 0.0;
    }


    public void displayStudentReport() {
        for (Student s : students) {
            System.out.println("Name: " + s.getStudent_name() + ", ID: " + s.getStudent_id());
            if (s.isRecordIncomplete()) {
                System.out.println("Record Incomplete");
            } else {
                System.out.println("Total: " + s.getTotal() + ", Average: " + s.getAverage());
            }
            System.out.println();
        }
    }


    public void displayClassAverage() {
        System.out.println("Class Average: " + getClassAverage());
    }
}
