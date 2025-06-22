import java.util.Scanner;

public class SimpleNumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        int high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100.");

        while (!feedback.equals("correct") && low <= high) {
            int guess = (low + high) / 2;
            System.out.println("Is your number " + guess + "?");
            System.out.print("Enter feedback (high / low / correct): ");
            feedback = sc.nextLine();

            if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (!feedback.equals("correct")) {
                System.out.println("Please enter valid feedback.");
            }
        }

        if (feedback.equals("correct")) {
            System.out.println("I guessed your number!");
        } else {
            System.out.println("Something went wrong. Maybe wrong hints?");
        }
    }
}
