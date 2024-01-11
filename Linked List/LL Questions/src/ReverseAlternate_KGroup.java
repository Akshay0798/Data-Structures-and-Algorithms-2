public class ReverseAlternate_KGroup {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        // Reverse alternate groups of size k
        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            // Reverse the group between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            // Skip the next k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
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
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        int k = 2;
        ReverseAlternate_KGroup reverser = new ReverseAlternate_KGroup();
        ListNode reversedList = reverser.reverseAlternateKGroup(head, k);

        // Print the reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }

        // Test case with an empty list
        ListNode emptyList = null;
        int kEmpty = 3;
        ListNode reversedEmptyList = reverser.reverseAlternateKGroup(emptyList, kEmpty);

        // Print the reversed empty list
        System.out.print("\nReversed Empty List: ");
        while (reversedEmptyList != null) {
            System.out.print(reversedEmptyList.val + " ");
            reversedEmptyList = reversedEmptyList.next;
        }
    }
}
