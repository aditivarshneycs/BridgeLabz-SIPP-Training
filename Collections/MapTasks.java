import java.util.*;

public class MapTasks {

    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.toLowerCase().replaceAll("[^a-z ]", "").split(" ");
        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map;
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> result = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return result;
    }

    public static String keyWithMaxValue(Map<String, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        for (String key : map2.keySet()) {
            result.put(key, result.getOrDefault(key, 0) + map2.get(key));
        }
        return result;
    }

    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String toString() {
            return name;
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        return grouped;
    }

    public static void main(String[] args) {
        System.out.println("Word Frequency: " + wordFrequency("Hello world, hello Java!"));

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1); map.put("B", 2); map.put("C", 1);
        System.out.println("Inverted Map: " + invertMap(map));

        Map<String, Integer> scores = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println("Key with Max Value: " + keyWithMaxValue(scores));

        Map<String, Integer> m1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> m2 = Map.of("B", 3, "C", 4);
        System.out.println("Merged Maps: " + mergeMaps(m1, m2));

        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        System.out.println("Grouped by Department: " + groupByDepartment(employees));
    }
}