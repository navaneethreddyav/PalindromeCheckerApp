import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 6.0
    */

    public static void main(String[] args){

        // Original String
        String original = "level";

        // Convert to lowercase (optional)
        original = original.toLowerCase();

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Push into Stack and Enqueue into Queue
        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO
        }

        boolean isPalindrome = true;

        // Compare dequeue (queue) with pop (stack)
        for (int i = 0; i < original.length(); i++) {

            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop

            if (fromQueue != fromStack) {
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
