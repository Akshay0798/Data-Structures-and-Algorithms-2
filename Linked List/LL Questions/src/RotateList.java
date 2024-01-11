public class RotateList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        // Check for base cases: no rotation needed
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        // Find the last node and calculate the length of the linked list
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // Connect the last node to the head, forming a circular linked list
        last.next = head;

        // Calculate the actual number of rotations needed
        int rotations = k % length;

        // Calculate the number of nodes to skip from the beginning
        int skip = length - rotations;

        // Traverse to the node just before the new last node
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        // Update the head and break the circular connection
        head = newLast.next;
        newLast.next = null;

        // Return the modified linked list with rotated elements
        return head;
    }
    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Rotate the list by k = 2
        int k = 2;
        RotateList rotateList = new RotateList();
        ListNode rotatedList = rotateList.rotateRight(head, k);

        // Print the rotated list
        while (rotatedList != null) {
            System.out.print(rotatedList.val + " ");
            rotatedList = rotatedList.next;
        }
    }
}

