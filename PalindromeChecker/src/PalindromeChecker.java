import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 12.0
    */

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String original) {

            String normalized = original.replaceAll("\\s+", "").toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < normalized.length(); i++) {
                stack.push(normalized.charAt(i));
            }

            for (int i = 0; i < normalized.length(); i++) {
                if (normalized.charAt(i) != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String original) {

            String normalized = original.replaceAll("\\s+", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();

            for (int i = 0; i < normalized.length(); i++) {
                deque.addLast(normalized.charAt(i));
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Context method (uses strategy)
    public boolean checkPalindrome(String original, PalindromeStrategy strategy) {
        return strategy.check(original);
    }

    public static void main(String[] args) {

        String original = "A man a plan a canal Panama";

        PalindromeChecker checker = new PalindromeChecker();

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // PalindromeStrategy strategy = new DequeStrategy();

        boolean isPalindrome = checker.checkPalindrome(original, strategy);

        if (isPalindrome) {
            System.out.println("\"" + original + "\" is a Palindrome (ignoring spaces & case).");
        } else {
            System.out.println("\"" + original + "\" is not a Palindrome (ignoring spaces & case).");
        }
    }
}