import java.util.Scanner;

public class FactorialRecursive {

    public static void main(String[] args) {
        int number = getInput("Enter a non-negative integer: ");
        long factorial = calculateFactorial(number);
        displayResult(number, factorial);
    }

    public static int getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    public static long calculateFactorial(int n) {
        if (n <= 1) return 1;
        return n * calculateFactorial(n - 1);
    }

    public static void displayResult(int number, long factorial) {
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
