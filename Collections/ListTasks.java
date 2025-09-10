import java.util.*;

public class ListTasks {

    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static Map<String, Integer> frequencyCount(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }

    public static <T> List<T> rotateList(List<T> list, int positions) {
        int n = list.size();
        List<T> rotated = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rotated.add(list.get((i + positions) % n));
        }
        return rotated;
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (seen.add(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) first.next();
            else return null;
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        System.out.println("Reversed ArrayList: " + reverseList(arrayList));
        System.out.println("Reversed LinkedList: " + reverseList(linkedList));

        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("Frequency Count: " + frequencyCount(fruits));

        List<Integer> rotList = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("Rotated List: " + rotateList(rotList, 2));

        List<Integer> dupList = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Removed Duplicates: " + removeDuplicates(dupList));

        LinkedList<String> stringList = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("2nd Element from End: " + findNthFromEnd(stringList, 2));
    }
}