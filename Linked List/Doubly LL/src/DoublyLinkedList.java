public class DoublyLinkedList {

    private class Node {
        int value;
        Node next;
        Node pre;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
        Node head;

        public void InsertFirst(int value){
            Node newNode = new Node(value);
            newNode.next=head;
            newNode.pre=null;
            if (head!=null){
                head.pre = newNode;
            }
            head = newNode;
        }
        public void display(){
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

