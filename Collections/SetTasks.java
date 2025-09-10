import java.util.*;

public class SetTasks {

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<T> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        result.removeAll(temp);
        return result;
    }

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Sets Equal: " + areSetsEqual(set1, set2));

        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Union: " + union(a, b));
        System.out.println("Intersection: " + intersection(a, b));
        System.out.println("Symmetric Difference: " + symmetricDifference(a, b));

        Set<Integer> unsorted = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertToSortedList(unsorted));

        Set<Integer> small = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> large = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Is Subset: " + isSubset(small, large));
    }
}