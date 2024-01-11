//https://leetcode.com/problems/palindrome-linked-list/

public class Palindrome {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Palindrome() {
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Move slow pointer by 1 and fast pointer by 2 to find the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        // Reverse the linked list by adjusting next pointers
        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reversedHeadSecond = headSecond;

        // Compare both halves of the linked list
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        // Reverse the second half again to restore the original list
        reverseList(reversedHeadSecond);

        if(head == null || headSecond == null){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Palindrome solution = new Palindrome();

        // Create a sample linked list
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Check if the linked list is a palindrome
        boolean isPalin = solution.isPalindrome(head);

        // Print the result
        System.out.println("Is the linked list a palindrome? " + isPalin);
    }
}
