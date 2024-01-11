import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
@SuppressWarnings("ALL")
//https://leetcode.com/problems/binary-tree-right-side-view/

public class RightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Function to get the right side view of a binary tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // Initialize the result list

        if (root == null) {
            return result; // If the tree is empty, return an empty result
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Create a queue for level-order traversal
        queue.offer(root); // Add the root node to the queue

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue a node from the queue

                if (i == levelSize - 1) {
                    // If it's the rightmost node in the current level, add its value to the result
                    result.add(currentNode.val);
                }

                // Add the left and right child nodes to the queue if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result; // Return the right side view result
    }

    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();

        // Create a sample binary tree
        TreeNode root = rightSideView.new TreeNode(1);
        root.left = rightSideView.new TreeNode(2);
        root.right = rightSideView.new TreeNode(3);
        root.left.right = rightSideView.new TreeNode(5);
        root.right.right = rightSideView.new TreeNode(4);

        // Get the right side view of the tree
        List<Integer> result = rightSideView.rightSideView(root);

        // Print the result
        System.out.println("Right Side View: " + result);
    }
}
//offer(root): The offer method is used to add an element to the end of the queue.
// In this case, we are adding the root node of the binary tree to the queue.
