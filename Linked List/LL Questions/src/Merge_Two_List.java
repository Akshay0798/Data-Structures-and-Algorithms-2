//https://leetcode.com/problems/merge-two-sorted-lists/
public class Merge_Two_List {
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

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static Merge_Two_List mergeTwoLists(Merge_Two_List first, Merge_Two_List second){
        Node f = first.head;
        Node s = second.head;

        Merge_Two_List ans = new Merge_Two_List();

        while(f != null && s!=null){
            if (f.val < s.val){
                ans.addLast(f.val);
                f = f.next;
            }
            else{
                ans.addLast(s.val);
                s = s.next;
            }
        }
        while(f != null){
            ans.addLast(f.val);
            f = f.next;
        }
        while(s != null){
            ans.addLast(s.val);
            s = s.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Merge_Two_List first = new Merge_Two_List();
        Merge_Two_List second = new Merge_Two_List();

        first.addLast(1);
        first.addLast(3);
        first.addLast(5);

        second.addLast(1);
        second.addLast(2);
        second.addLast(9);
        second.addLast(14);

        Merge_Two_List ans = Merge_Two_List.mergeTwoLists(first,second);
        ans.display();

    }

}
