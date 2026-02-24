import java.util.Deque;
import java.util.LinkedList;

public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 7.0
    */

    public static void main(String[] args){

        // Original String
        String original = "level";

        // Convert to lowercase (optional)
        original = original.toLowerCase();

        // Create Deque (Double Ended Queue)
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < original.length(); i++) {
            deque.addLast(original.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {

            char front = deque.removeFirst();   // Remove from front
            char rear = deque.removeLast();     // Remove from rear

            if (front != rear) {
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
