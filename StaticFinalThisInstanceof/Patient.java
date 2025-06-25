class Patient {
    static String hospitalName = "General Hospital";
    static int totalPatients = 0;
    final int patientID;
    String name;
    int age;
    String ailment;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Name: " + name + ", Age: " + age + ", Ailment: " + ailment + ", ID: " + patientID);
        }
    }
}
