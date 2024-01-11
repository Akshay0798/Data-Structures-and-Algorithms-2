//https://leetcode.com/problems/linked-list-cycle-ii/

import java.util.List;

public class DetectCycleStart {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    public ListNode detectCycle(ListNode head){
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;

    }
    public static void main(String[] args) {
        DetectCycleStart solution = new DetectCycleStart();

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
