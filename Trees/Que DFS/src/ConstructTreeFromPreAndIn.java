//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
import java.util.Arrays;

public class ConstructTreeFromPreAndIn {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start the tree-building process with the entire preorder and inorder arrays
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // If the preorder array is empty, return null (base case)
        if (preStart == preEnd) {
            return null;
        }

        // The root value is the first element in the preorder array
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root value in the inorder array
        int rootIndex = inStart;
        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndex - inStart;

        // Recursively build the left subtree using a subset of the preorder and inorder arrays
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + 1 + leftSubtreeSize, inorder, inStart, rootIndex);

        // Recursively build the right subtree using a subset of the preorder and inorder arrays
        root.right = buildTreeHelper(preorder, preStart + 1 + leftSubtreeSize, preEnd, inorder, rootIndex + 1, inEnd);

        // Return the root of the constructed binary tree
        return root;
    }
}
/*
root.left = buildTreeHelper(preorder, preStart + 1, preStart + 1 + leftSubtreeSize, inorder, inStart, rootIndex);
        The code starts by assigning the left child of the current root node.
        It calls the buildTreeHelper method recursively to construct the left subtree.

        For the preorder array, it narrows down the range by incrementing preStart by 1 and
        adding leftSubtreeSize to it, which essentially removes the elements corresponding to the root and its right subtree.

        For the inorder array, it keeps the same inStart and updates rootIndex as the endpoint.
        This range represents the elements of the left subtree in the inorder traversal.
*/

