//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class Remove_Duplicate {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    Node head;
    Node tail;
    int size;

    Remove_Duplicate() {
        size = 0;
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void duplicate(){
        Node temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail=temp;
        tail.next=null;
    }
    public static void main(String[] args) {
        Remove_Duplicate list = new Remove_Duplicate();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.printList();

        list.duplicate();
        list.printList();




    }
}
