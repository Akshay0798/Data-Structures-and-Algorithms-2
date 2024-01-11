import java.util.Arrays;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/game-of-two-stacks/problem

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];// Create an array to store the elements of the first stack
            int[] b = new int[m];// Create an array to store the elements of the second stack
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();  // Read the elements of the first stack
            }
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();   // Read the elements of the second stack
            }
            int result = GameOfTwoStacks.twoStack(x, a, b);  // Calculate the maximum number of elements that can be picked
            System.out.println("Maximum number of elements that can be picked: " + result);
        }
    }

    static class GameOfTwoStacks {
        static int twoStack(int x, int[] a, int[] b) {
            // Invoke the helper method with initial values, and subtract 1 to exclude the extra count
            return twoStack(x, a, b, 0, 0) -1 ;
        }

        private static int twoStack(int x, int[] a, int[] b, int sum, int count) {
            if (sum > x) {
                return count; // If the sum exceeds the maximum allowed value, return the current count
            }
            if (a.length == 0 || b.length == 0) {
                return count;// If either of the stacks is empty, return the current count
            }
            int ans1 = twoStack(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
            // Recursively call the helper method, excluding the first element of stack 'a,'
            // updating the sum and count accordingly
            int ans2 = twoStack(x, a, Arrays.copyOfRange(b, 1, b.length), sum + a[0], count + 1);
            // Recursively call the helper method, excluding the first element of stack 'b,'
            // updating the sum and count accordingly
            return Math.max(ans1, ans2);
            // Return the maximum count obtained from both recursive calls
        }
    }
}

