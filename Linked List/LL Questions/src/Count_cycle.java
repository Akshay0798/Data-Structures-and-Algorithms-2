//Q: find length of cycle
public class Count_cycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class Solution {
        public int lengthCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    //calculate Length
                    ListNode temp=slow;
                    int length = 0;
                    do{
                        temp=temp.next;
                        length++;
                    }while(temp != slow);
                    return length;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Count_cycle countCycle = new Count_cycle();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second; // creating a cycle

        Solution solution = new Solution();
        int cycleLength = solution.lengthCycle(head);
        System.out.println("Length of the cycle: " + cycleLength);
    }

}
