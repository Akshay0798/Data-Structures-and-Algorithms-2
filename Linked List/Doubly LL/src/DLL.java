public class DLL {
    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    Node tail;

    public void addNode(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertFirst(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        newnode.prev = null;
        if (head != null) {
            head.prev = newnode;
        }
        head = newnode;
    }

    public void insertLast(int val) {
        Node newNode = new Node(val);
        Node Temp = head;

        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (Temp.next != null) {
            Temp = Temp.next;
        }
        Temp.next = newNode;
        newNode.prev = Temp;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    //insert node after a particular value
    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("value "+ after + " not exist in list" );
            return;
        }

        Node newNode = new Node(val);
        newNode.next = p.next;
        p.next = newNode;
        newNode.prev = p;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public void displayForwardTraversal() {
        System.out.println("Forward traversal:");
        Node Temp = head;
        while (Temp != null) {
            System.out.print(Temp.val + " -> ");
            Temp = Temp.next;
        }
        System.out.println("END");
    }

    public void displayReverseTraversal() {
        System.out.println("Reverse traversal:");
        Node temp = head;
        while(temp.next != null){ // Traverse to the last node
            temp = temp.next;
        }
        while (temp != null){
            System.out.print(temp.val + " -> ");  // Traverse backwards and print the data
            temp = temp.prev;
        }

        System.out.println("START");
    }




}




