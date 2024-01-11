public class Reverse_KGroup {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Calculate the length of the linked list
    public static int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    // Reverse the linked list in groups of size k
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        // Calculate the length of the linked list
        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = current;

            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                // Reverse the current node by adjusting next pointers
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                // Connect the previous reversed group with the current reversed group
                last.next = prev;
            } else {
                // Update the head pointer for the first reversed group
                head = prev;
            }

            // Connect the end of the current reversed group with the next group
            newEnd.next = current;

            // Update the prev pointer for the next iteration
            prev = newEnd;
            count--;
        }
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

        // Reverse the linked list in groups of size k
        int k = 2;
        ListNode reversedList = reverseKGroup(head, k);

        // Print the reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
}
