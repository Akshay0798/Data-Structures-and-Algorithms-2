//https://leetcode.com/problems/reorder-list/description/
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode reversedSecondHalf = reverseList(mid);
        ListNode firstHalf = head;

        // Rearrange the nodes
        while (firstHalf != null && reversedSecondHalf != null) {
            ListNode temp = firstHalf.next;
            firstHalf.next = reversedSecondHalf;
            firstHalf = temp;

            temp = reversedSecondHalf.next;
            reversedSecondHalf.next = firstHalf;
            reversedSecondHalf = temp;
        }

        // Set the next of the tail to null
        if (firstHalf != null) {
            firstHalf.next = null;
        }
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();

        // Create a sample linked list
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Reorder the list
        solution.reorderList(head);

        // Print the reordered list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

