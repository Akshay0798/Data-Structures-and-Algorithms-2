import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
@SuppressWarnings("ALL")


//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class ZigZagLevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>(); // Initialize the result list for zigzag traversal
        if (root == null) return zigzag; // If the tree is empty, return an empty result list

        Queue<TreeNode> queue = new LinkedList<>(); // Create a queue for level-order traversal
        queue.add(root); // Add the root node to the queue
        boolean flag = false; // Initialize a flag to control zigzag direction

        while (!queue.isEmpty()) {
            int size = queue.size(); // Get the number of nodes at the current level
            List<Integer> level = new ArrayList<>(); // Initialize a list for the current level's values
            Stack<Integer> reverseStack = new Stack<>(); // Initialize a stack to reverse the values

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Dequeue a node from the queue

                // Depending on the flag, add the node's value to the level list or push it onto the stack
                if (flag)
                    reverseStack.add(node.val);
                else
                    level.add(node.val);

                // Add the left and right child nodes to the queue if they exist
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag; // Toggle the flag to change zigzag direction for the next level

            // Pop all elements from the stack and add them to the level list to reverse the order
            while (!reverseStack.isEmpty())
                level.add(reverseStack.pop());

            zigzag.add(level); // Add the current level's values to the result list
        }

        return zigzag; // Return the zigzag level-order traversal result
    }

    public static void main(String[] args) {
        // Build a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of ZigZagLevelOrder
        ZigZagLevelOrder zigzagOrder = new ZigZagLevelOrder();

        // Call the zigzagLevelOrder method to get the zigzag level-order traversal
        List<List<Integer>> result = zigzagOrder.zigzagLevelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}

/*
normal order:
-> remove from front & Add in back
Zig Zag Order:
-> remove from back & Add in Front
*/

