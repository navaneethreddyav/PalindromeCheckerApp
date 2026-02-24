public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 9.0
    */

    public static void main(String[] args) {

        // Original String
        String original = "level";

        // Convert to lowercase (optional)
        original = original.toLowerCase();

        // Check palindrome using recursion
        boolean isPalindrome = isPalindromeRecursive(original, 0, original.length() - 1);

        // Display result
        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is not a Palindrome.");
        }
    }

    // Recursive method to check palindrome
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base case: crossed over or single character
        if (start >= end) {
            return true;
        }

        // If characters mismatch
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call moving towards center
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}
