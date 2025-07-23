import java.util.*;

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        ResumeProcessor.processResumes(jobRoles);
    }
}

abstract class JobRole {
    String title;
    public JobRole(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getRole() {
        return role;
    }
}

class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Processing role: " + role.getTitle());
        }
    }
}
