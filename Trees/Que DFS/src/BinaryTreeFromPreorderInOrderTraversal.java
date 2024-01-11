import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderInOrderTraversal {
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

    // Method to build a binary tree from its preorder and inorder traversal sequences
    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        // Create a map to store indices of elements in the inorder traversal
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

        // Populate the map with indices of elements from the inorder traversal
        for (int i = 0; i < inOrder.length; i++)
            inOrderIndexMap.put(inOrder[i], i);

        // Call the splitTree method to construct the binary tree
        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    // Recursive function to split the tree and build it
    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right) {
        // Check if boundaries are invalid (base case for recursion)
        if (left > right) {
            return null; // Return null to indicate no further nodes in this branch
        }

        // Create a new TreeNode with the value from the current rootIndex in preorder
        TreeNode root = new TreeNode(preOrder[rootIndex]);

        // Find the index of the root value in the inorder traversal
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);

        // Calculate the size of the left subtree
        int leftSubtreeSize = mid - left;

        // Recursively build left and right subtrees
        root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + leftSubtreeSize + 1, mid + 1, right);

        return root; // Return the constructed tree rooted at 'root'
    }
}
