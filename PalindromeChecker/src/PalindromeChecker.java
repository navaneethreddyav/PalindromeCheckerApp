public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 2.0
     */

    public static void main(String[] args){

        // Original String
        String original = "level";

        // Convert string to character array
        char[] characters = original.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is not a Palindrome.");
        }
    }
}
