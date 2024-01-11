import java.util.LinkedList;
import java.util.Queue;

public class Mirror {
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

    // Function to check if a binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // Check if the tree is empty; an empty tree is symmetric by definition
        if (root == null) {
            return true;
        }

        // Create a queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // Add the left and right children of the root to the queue initially
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            // Retrieve the left and right nodes from the queue
            TreeNode leftChild = queue.poll();
            TreeNode rightChild = queue.poll();

            // If both nodes are null, they don't need to be compared, so continue
            if (leftChild == null && rightChild == null) {
                continue;
            }

            // If one of the nodes is null while the other is not, the tree is not symmetric
            if (leftChild == null || rightChild == null) {
                return false;
            }

            // Compare the values of the left and right nodes
            if (leftChild.val != rightChild.val) {
                return false;
            }

            // Add the children of the left node and right node for further comparison
            queue.add(leftChild.left);
            queue.add(rightChild.right);
            queue.add(leftChild.right);
            queue.add(rightChild.left);
        }

        // If the loop completes without finding any symmetry issues, the tree is symmetric
        return true;
    }
}
