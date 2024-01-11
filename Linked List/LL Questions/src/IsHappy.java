//https://leetcode.com/problems/happy-number/description/
public class IsHappy {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);// Move slow pointer one step
            fast = findSquare(findSquare(fast));// Move fast pointer two steps
        } while (slow != fast); // Repeat until slow and fast pointers meet


        // If the cycle contains 1, then n is a happy number
        if (slow == 1) {
            return true;
        }
        return false;
    }
    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        IsHappy solution = new IsHappy();

        int number = 19;
        boolean isNumberHappy = solution.isHappy(number);
        System.out.println(number + " is happy: " + isNumberHappy);
    }
}
