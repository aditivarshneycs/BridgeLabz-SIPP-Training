import java.util.*;

public class QueueTasks {

    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }

    public static List<String> generateBinaryNumbers(int N) {
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();
        q.add("1");
        while (N-- > 0) {
            String s = q.poll();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }

    static class Patient implements Comparable<Patient> {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        public int compareTo(Patient other) {
            return Integer.compare(other.severity, this.severity);
        }

        public String toString() {
            return name + "(" + severity + ")";
        }
    }

    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop() {
            return q1.remove();
        }

        int top() {
            return q1.peek();
        }
    }

    static class CircularBuffer {
        int[] buffer;
        int head = 0, size = 0;

        CircularBuffer(int capacity) {
            buffer = new int[capacity];
        }

        void insert(int val) {
            buffer[(head + size) % buffer.length] = val;
            if (size < buffer.length) size++;
            else head = (head + 1) % buffer.length;
        }

        void printBuffer() {
            for (int i = 0; i < size; i++) {
                System.out.print(buffer[(head + i) % buffer.length] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Reversed Queue: " + reverseQueue(q));

        System.out.println("Binary Numbers: " + generateBinaryNumbers(5));

        PriorityQueue<Patient> pq = new PriorityQueue<>();
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));
        System.out.println("Hospital Triage Order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1); stack.push(2); stack.push(3);
        System.out.println("Top of Stack: " + stack.top());
        System.out.println("Pop from Stack: " + stack.pop());

        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1); buffer.insert(2); buffer.insert(3); buffer.insert(4);
        System.out.print("Circular Buffer: ");
        buffer.printBuffer();
    }
}