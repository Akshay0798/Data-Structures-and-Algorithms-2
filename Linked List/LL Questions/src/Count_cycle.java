//Q: find length of cycle
public class Count_cycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class Solution {
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
        ListNode head = countCycle.new ListNode(1);
        ListNode second = countCycle.new ListNode(2);
        ListNode third = countCycle.new ListNode(3);
        ListNode fourth = countCycle.new ListNode(4);
        ListNode fifth = countCycle.new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second; // creating a cycle

        Solution solution = countCycle.new Solution();
        int cycleLength = solution.lengthCycle(head);
        System.out.println("Length of the cycle: " + cycleLength);
    }

}
