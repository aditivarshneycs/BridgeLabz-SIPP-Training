import java.util.*;
import java.text.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String holderName;
    Date expiryDate;
    String coverageType;
    double premium;

    public Policy(String policyNumber, String holderName, String expiryDateStr, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.coverageType = coverageType;
        this.premium = premium;
        try {
            this.expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateStr);
        } catch (ParseException e) {
            this.expiryDate = new Date();
        }
    }

    public String toString() {
        return policyNumber + " - " + holderName + " - " + coverageType + " - " + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate);
    }

    public int compareTo(Policy p) {
        return this.expiryDate.compareTo(p.expiryDate);
    }

    public boolean equals(Object o) {
        if (o instanceof Policy) {
            return this.policyNumber.equals(((Policy) o).policyNumber);
        }
        return false;
    }

    public int hashCode() {
        return policyNumber.hashCode();
    }
}

public class InsurancePolicySystem {

    public static void main(String[] args) {
        HashSet<Policy> hashSet = new HashSet<>();
        LinkedHashSet<Policy> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Policy> treeSet = new TreeSet<>();

        Policy p1 = new Policy("P101", "Alice", "2025-08-01", "Health", 5000);
        Policy p2 = new Policy("P102", "Bob", "2025-07-30", "Auto", 3000);
        Policy p3 = new Policy("P103", "Charlie", "2025-08-15", "Home", 6000);
        Policy p4 = new Policy("P102", "Bob", "2025-07-30", "Auto", 3000); // duplicate

        hashSet.add(p1); hashSet.add(p2); hashSet.add(p3); hashSet.add(p4);
        linkedHashSet.add(p1); linkedHashSet.add(p2); linkedHashSet.add(p3); linkedHashSet.add(p4);
        treeSet.add(p1); treeSet.add(p2); treeSet.add(p3); treeSet.add(p4);

        System.out.println("Unique Policies in HashSet:");
        for (Policy p : hashSet) System.out.println(p);

        System.out.println("\nPolicies in Insertion Order (LinkedHashSet):");
        for (Policy p : linkedHashSet) System.out.println(p);

        System.out.println("\nPolicies Sorted by Expiry (TreeSet):");
        for (Policy p : treeSet) System.out.println(p);

        System.out.println("\nPolicies expiring in next 30 days:");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date limit = cal.getTime();
        for (Policy p : treeSet) {
            if (p.expiryDate.before(limit)) {
                System.out.println(p);
            }
        }

        System.out.println("\nPolicies with coverage type 'Auto':");
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase("Auto")) {
                System.out.println(p);
            }
        }

        System.out.println("\nDuplicate Policies (based on policy number):");
        Set<String> seen = new HashSet<>();
        for (Policy p : linkedHashSet) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }
}