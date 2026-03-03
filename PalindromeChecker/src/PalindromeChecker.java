import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 13.0
    */

    interface PalindromeStrategy {
        boolean check(String input);
    }

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

    public boolean checkPalindrome(String original, PalindromeStrategy strategy) {
        return strategy.check(original);
    }

    public static void main(String[] args) {

        String original = "A man a plan a canal Panama";

        PalindromeChecker checker = new PalindromeChecker();

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        long startTime, endTime;

        // Stack Performance
        startTime = System.nanoTime();
        boolean stackResult = checker.checkPalindrome(original, stackStrategy);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Deque Performance
        startTime = System.nanoTime();
        boolean dequeResult = checker.checkPalindrome(original, dequeStrategy);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        System.out.println("Stack Result: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Result: " + dequeResult + " | Time: " + dequeTime + " ns");
    }
}