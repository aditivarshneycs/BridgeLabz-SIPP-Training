import java.util.*;

class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    List<Employee> employees = new ArrayList<>();
    Department(String name) {
        this.name = name;
    }
    void addEmployee(Employee e) {
        employees.add(e);
    }
}

class Company {
    String name;
    List<Department> departments = new ArrayList<>();
    Company(String name) {
        this.name = name;
    }
    void addDepartment(Department d) {
        departments.add(d);
    }
}

public class Company_Department {
    public static void main(String[] args) {
        Company c = new Company("Infosys");
        Department d1 = new Department("IT");
        d1.addEmployee(new Employee("Raj"));
        d1.addEmployee(new Employee("Simran"));
        c.addDepartment(d1);
    }
}
