import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        String input = getInput("Enter a string: ");
        boolean isPalindrome = checkPalindrome(input);
        displayResult(input, isPalindrome);
    }

    public static String getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine().replaceAll("\\s+", "").toLowerCase();
    }

    public static boolean checkPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void displayResult(String original, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("\"" + original + "\" is a palindrome.");
        } else {
            System.out.println("\"" + original + "\" is not a palindrome.");
        }
    }
}
