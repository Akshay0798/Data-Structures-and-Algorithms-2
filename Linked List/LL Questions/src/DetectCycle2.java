//https://leetcode.com/problems/linked-list-cycle-ii/

public class DetectCycle2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null; // Empty linked list
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null; // No cycle
        }

        slow = head; // Move a slow pointer back to the head

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Node where the cycle begins
    }

    public static void main(String[] args) {
        DetectCycle2 solution = new DetectCycle2();

        // Create a linked list with a cycle
        ListNode head = solution.new ListNode(3);
        ListNode node2 = solution.new ListNode(2);
        ListNode node0 = solution.new ListNode(0);
        ListNode nodeNeg4 = solution.new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2; // Cycle formed

        ListNode result = solution.detectCycle(head);
        if (result != null) {
            System.out.println("Tail connects to node index: " + result.val);
        } else {
            System.out.println("No cycle");
        }
    }
}
