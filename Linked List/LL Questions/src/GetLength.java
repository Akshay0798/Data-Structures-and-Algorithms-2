public class GetLength {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public int geTLength(ListNode head) {
        ListNode node = head; // Start with the head of the linked list
        int length = 0; // Initialize the length to 0

        while (node != null) { // Traverse the linked list until the end
            length++; // Increment the length for each node visited
            node = node.next; // Move to the next node
        }

        return length; // Return the final length of the linked list
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

        GetLength lengthCalculator = new GetLength(); // Create an instance of the GetLength class
        int length = lengthCalculator.geTLength(head); // Call the getLength method to calculate the length

        System.out.println("Length of the linked list: " + length); // Print the calculated length
    }

}
