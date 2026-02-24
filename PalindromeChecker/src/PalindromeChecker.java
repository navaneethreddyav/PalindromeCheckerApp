import java.util.Stack;

public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 2.0
     */

    public static void main(String[] args){

        // Original String
        String original = "level";

        // Convert to lowercase (optional)
        original = original.toLowerCase();

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop and compare
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is not a Palindrome.");
        }
    }
}
