import java.util.Scanner;

public class GcdLcmCalculator {

    public static void main(String[] args) {
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }

    public static int getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calculateLCM(int a, int b, int gcd) {
        return (a / gcd) * b;
    }
}
