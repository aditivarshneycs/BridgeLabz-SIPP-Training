import java.util.*;

class Patient {
    String name;
    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();
    Doctor(String name) {
        this.name = name;
    }
    void consult(Patient p) {
        patients.add(p);
        System.out.println(name + " consulted " + p.name);
    }
}

class Hospital {
    String name;
    Hospital(String name) {
        this.name = name;
    }
}

public class Hospital_P {
    public static void main(String[] args) {
        Hospital h = new Hospital("AIIMS");
        Doctor d1 = new Doctor("Dr. Mehta");
        Patient p1 = new Patient("Rahul");
        Patient p2 = new Patient("Neha");

        d1.consult(p1);
        d1.consult(p2);
    }
}
