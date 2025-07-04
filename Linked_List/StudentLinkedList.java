
class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentLinkedList {
    private Student head;

    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Student added at beginning.");
    }

    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            System.out.println("Student added as first student.");
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
        System.out.println("Student added at end.");
    }

    public void addAtPosition(int rollNo, String name, int age, char grade, int position) {
        if (position <= 0) {
            System.out.println("Invalid position. Must be >= 1.");
            return;
        }

        Student newStudent = new Student(rollNo, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            System.out.println("Student added at position 1.");
            return;
        }

        Student current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newStudent.next = current.next;
        current.next = newStudent;
        System.out.println("Student added at position " + position + ".");
    }

    public void deleteByRoll(int rollNo) {
        Student current = head;
        Student previous = null;

        while (current != null && current.rollNo != rollNo) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
            return;
        }

        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }

        System.out.println("Student with Roll No " + rollNo + " deleted.");
    }

    public void searchByRoll(int rollNo) {
        Student current = head;

        while (current != null) {
            if (current.rollNo == rollNo) {
                System.out.println("Found: Roll No: " + current.rollNo + ", Name: " + current.name +
                        ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }

        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void updateGrade(int rollNo, char newGrade) {
        Student current = head;

        while (current != null) {
            if (current.rollNo == rollNo) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll No " + rollNo + ".");
                return;
            }
            current = current.next;
        }

        System.out.println("Student with Roll No " + rollNo + " not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Student current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtEnd(1, "Alice", 20, 'A');
        list.addAtBeginning(2, "Bob", 19, 'B');
        list.addAtPosition(3, "Charlie", 21, 'C', 2);
        list.displayAll();

        list.searchByRoll(3);
        list.updateGrade(3, 'A');
        list.displayAll();

        list.deleteByRoll(2);
        list.displayAll();
    }
}