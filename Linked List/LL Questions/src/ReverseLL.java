// Q.Rev LL but condition is no extra space, so SC is O(1) TC is O(n)
public class ReverseLL {
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }
    Node head;
    Node tail;


    public void addLast(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseIterate(){
        if (head==null){
            System.out.println("LL Empty");
            return;
        }
        if(head.next==null){
            System.out.println("Only one Node");
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next=prevNode;

            //update
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    public Node reverseRecursion(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
    ReverseLL list=new ReverseLL();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.printList();

        list.reverseIterate();
        list.printList();

        list.head=list.reverseRecursion(list.head);
        list.printList();

    }
}
