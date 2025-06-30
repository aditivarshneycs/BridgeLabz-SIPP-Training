public class Student {
    public String student_name;

    public String student_id;

    public Integer[] subjectGrade ;

    public Student(String student ,String student_id, int subjectCount) {
        this.student_name = student;
        this.student_id = student_id;
        this.subjectGrade = new Integer[subjectCount];
    }

    public  void setSubjectGrade(int subjectIndex , int grade){
    if(grade < 0 || grade > 100){
        throw  new IllegalArgumentException("Grade must be in 0 to 100");
    }
    subjectGrade[subjectIndex] = grade;
    }

    public String getStudent_name(){
        return student_name;
    }

    public String getStudent_id(){
        return student_id;
    }

    public Integer[] getSubjectGrade(){
        return subjectGrade;
    }

    public int getTotal(){
        int total = 0;
        for(Integer g : subjectGrade){
            if(g != null){
                total += g;
            }
        }
        return total;
    }

    public  double  getAverage(){
        int total = 0 , count = 0;
        for(Integer g : subjectGrade){
            if(g != null){
                total += g;
                count++;
            }
        }
        return (count > 0) ? (double) total/count : 0.0;
    }

    public boolean isRecordIncomplete() {
        for (Integer g : subjectGrade) {
            if (g == null) return true;
        }
        return false;
    }




}
