public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 10.0
    */

    public static void main(String[] args) {

        // Original String with spaces & mixed case
        String original = "A man a plan a canal Panama";

        // Normalize string: remove spaces & convert to lowercase
        String normalized = original.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome using recursive method
        boolean isPalindrome = isPalindromeRecursive(normalized, 0, normalized.length() - 1);

        // Display result
        if (isPalindrome) {
            System.out.println("\"" + original + "\" is a Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("\"" + original + "\" is not a Palindrome (ignoring spaces & case).");
        }
    }

    // Recursive palindrome check
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base case
        if (start >= end) {
            return true;
        }

        // Mismatch
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}