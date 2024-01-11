//https://leetcode.com/problems/sort-list/
public class Sort_List {
        static class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        public Sort_List() {
        }

        // Function to sort the linked list using merge sort
        public ListNode sortList(ListNode head) {
            // Base case: if the list is empty or has only one node, it is already sorted
            if (head == null || head.next == null) {
                return head;
            }

            // Find the middle node of the list
            ListNode mid = getMid(head);

            // Recursive calls to sort the left and right halves
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            // Merge the sorted left and right halves
            return merge(left, right);
        }

        // Function to merge two sorted linked lists
        ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead;

            // Merge the two lists by comparing the values of nodes
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }

            // Append any remaining nodes in list1 or list2
            if (list1 != null) {
                temp.next = list1;
            } else {
                temp.next = list2;
            }

            // Return the head of the merged list
            return dummyHead.next;
        }

        // Function to find the middle node of the list
        ListNode getMid(ListNode head) {
            ListNode midPrev = null;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                midPrev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            // Disconnect the two halves
            if (midPrev != null) {
                midPrev.next = null;
            }

            // Return the middle node
            return slow;
        }

        public static void main(String[] args) {
            Sort_List solution = new Sort_List();

            // Create a linked list
            ListNode head = new ListNode(4);
            ListNode node2 = new ListNode(2);
            ListNode node1 = new ListNode(1);
            ListNode node3 = new ListNode(3);

            head.next = node2;
            node2.next = node1;
            node1.next = node3;

            // Sort the linked list
            ListNode sortedList = solution.sortList(head);

            // Print the sorted linked list
            while (sortedList != null) {
                System.out.print(sortedList.val + " ");
                sortedList = sortedList.next;
            }
        }
    }
