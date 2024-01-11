//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
@SuppressWarnings("ALL")


public class LevelOrderTraversal {
    static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Create a list to store the result, which will be a list of lists.
        List<List<Integer>> result = new ArrayList<>();

        // Check if the root of the tree is null (empty tree).
        if (root == null) {
            // If the tree is empty, return an empty result.
            return result;
        }

        // Create a queue to perform a level-order traversal of the tree.
        Queue<TreeNode> queue = new LinkedList<>();

        // Add the root node to the queue to start the traversal.
        queue.offer(root);

        // Start a loop that continues until the queue is empty (all levels are processed).
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level (initially, it's just the root).
            int levelSize = queue.size();

            // Create a list to store the values of nodes at the current level.
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            // Process all nodes at the current level.
            for (int i = 0; i < levelSize; i++) {
                // Remove the front node from the queue (current node at the current level).
                TreeNode currentNode = queue.poll();

                // Add the value of the current node to the current level's list.
                currentLevel.add(currentNode.val);

                // Add the left child of the current node to the queue if it exists.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add the right child of the current node to the queue if it exists.
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the list of values at the current level to the result.
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        List<List<Integer>> result = levelOrderTraversal.levelOrder(root);
        System.out.println(result);
    }
}

//        Input: root = [3,9,20,null,null,15,7]
//        Output: [[3],[9,20],[15,7]]


//        Input: root = [1]
//        Output: [[1]]

//        Input: root = []
//        Output: []
