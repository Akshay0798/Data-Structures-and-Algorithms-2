public class Traverse {

    class Node {
        int Info;
        Node next;
        Node pre;

        Node(int value) {
            this.Info = value;
        }

        public Node(int value,Node next, Node pre) {
            this.Info = value;
            this.next = next;
            this.pre = pre;
        }
    }
    Node head;
    Node end;

    void InsertLast(int value){
        Node newNode = new Node(value);

        if (head == null){
            head = newNode;
            end = newNode;
            newNode.pre = null;
            newNode.next = null;
        }
        else {
            Node temp = end;
            newNode.next = null;
            newNode.pre = temp;
            temp.next = newNode;
            end = newNode;
        }
    }
    void InsertFirst(int value){
        Node newNode = new Node(value);

        if (head == null){
            head = newNode;
            end = newNode;
            newNode.pre = null;
            newNode.next = null;
        }
        else {
            Node temp = head;
            newNode.next = temp;
            newNode.pre = null;
            temp.pre = newNode;
            head = newNode;
        }
    }
    void Delete(int value){
        if (head == null){
            System.out.println("LL Empty. can not delete");
            
        }
        else if ((head.Info ==value) && (head.next==null) && (end.pre==null))  {
            head = null;
            end = null;

        }
        else if (head.Info ==value) {
            Node temp = head;
            head=head.next;
            head.pre=null;
            temp=null;
        }
        else if (end.Info ==value) {
            Node temp=end;
            end = end.pre;
            end.next = null;
            temp=null;
        }
        else {
            Node temp = head.next;
            while (temp != end)
            {
                if(temp.Info ==value){
                    break;
                }
                else{
                    temp=temp.next;
                }
                if (temp != end){
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.next;
                    temp = null;
                } else {
                    System.out.println("Node for deletion is not found in LL");
                }
            }
        }
    }

    void Traverse_LR(){
        if (head == null){
            System.out.println("LL is empty");
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.Info + " -> ");
                temp = temp.next;

            }
            System.out.println("End");
        }
    }
    void Traverse_RL(){
        if (head == null){
            System.out.println("LL is empty");
        }
         Node temp = end;
        while (temp != null){
            System.out.print(temp.Info + " -> ");
            temp=temp.pre;
        }
        System.out.println("Start");
    }
}

class LR{
    public static void main(String[] args) {
        Traverse list = new Traverse();
        list.InsertLast(10);
        list.Traverse_LR();

        list.InsertLast(20);
        list.InsertLast(30);
        list.Traverse_LR();
        list.Traverse_RL();

        list.InsertFirst(99);
        list.Traverse_LR();

        list.Delete(99);
        list.Traverse_LR();

        list.Delete(30);
        list.Traverse_LR();

        list.InsertFirst(58);
        list.Traverse_LR();

        list.Delete(80);





    }
}
