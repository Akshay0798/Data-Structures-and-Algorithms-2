public class Circuler {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    public  void insertLast(int val){
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void insertFirst(int val){
        Node newNode = new Node(val);
        if (head == null){
            newNode.next = newNode;
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
                newNode.next = head;
                temp.next = newNode;
                head = newNode;
            }
    }
    public void delete(int val){
        Node newNode = head;
        boolean nodeFound = false; // Flag to track if the node was found

        // Check if the list is empty
        if (newNode == null) {
            return;
        }
        // Case 1: Only one node in the list
        if (head == tail  && newNode.val == val){
            head = null;
            tail = null;
            return;
        }
        // Case 2: Delete the head node
        if (newNode.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }
        // Traverse the list to find the node to delete
        do {
            Node nextNode = newNode.next;
            if (nextNode.val == val) {
                newNode.next = nextNode.next;
                nodeFound = true; // Node found
                break;
            }
            newNode = newNode.next;
        } while (newNode != head);

        // If node not found, print message
        if (!nodeFound) {
            System.out.println("Node with value " + val + " not found in the circular linked list.");
        }
    }

    public void Display() {
        if (head == null) {
            System.out.println("Circular linked list is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("Back to head");
    }
}


