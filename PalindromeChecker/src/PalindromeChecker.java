public class PalindromeChecker {
    /*
    author : Navaneeth
    version : 8.0
    */

    // Node class (Singly Linked List)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){

        // Original String
        String original = "level";

        // Convert to lowercase (optional)
        original = original.toLowerCase();

        // Convert string to Singly Linked List
        Node head = null;
        Node tail = null;

        for (int i = 0; i < original.length(); i++) {
            Node newNode = new Node(original.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        boolean isPalindrome = true;

        if (head != null && head.next != null) {

            // Step 1: Find middle (Fast & Slow pointer)
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Step 2: Reverse second half
            Node prev = null;
            Node current = slow;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Step 3: Compare first half and reversed second half
            Node firstHalf = head;
            Node secondHalf = prev;

            while (secondHalf != null) {
                if (firstHalf.data != secondHalf.data) {
                    isPalindrome = false;
                    break;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
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
