import java.util.Stack;

public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 11.0
    */

    // Encapsulated palindrome logic
    public boolean checkPalindrome(String original) {

        // Normalize string: remove spaces & convert to lowercase
        String normalized = original.replaceAll("\\s+", "").toLowerCase();

        // Internal Data Structure: Stack
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare with reversed order using stack
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Original String with spaces & mixed case
        String original = "A man a plan a canal Panama";

        // Create object (OOPS)
        PalindromeChecker checker = new PalindromeChecker();

        // Call encapsulated method
        boolean isPalindrome = checker.checkPalindrome(original);

        // Display result
        if (isPalindrome) {
            System.out.println("\"" + original + "\" is a Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("\"" + original + "\" is not a Palindrome (ignoring spaces & case).");
        }
    }
}