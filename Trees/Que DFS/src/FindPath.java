public class FindPath {

    public static class TreeNode {
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

    public static void main(String[] args) {
        FindPath finder = new FindPath(); // Create an instance of the FindPath class

        // Creating a simple binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);

        int[] pathToFind = {3, 1, 2};

        boolean pathExists = finder.findPath(root, pathToFind); // Check if the specified path exists in the tree

        // Print the result based on whether the specified path exists in the tree or not
        if (pathExists) {
            System.out.println("The specified path exists in the tree.");
        } else {
            System.out.println("The specified path does not exist in the tree.");
        }
    }

    // Method to find a path in a binary tree
    boolean findPath(TreeNode node, int[] arr) {
        // If the root node is null, return true if the path array is also empty
        if (node == null) {
            return arr.length == 0;
        }
        // Call a helper method to check if the path exists starting from the root node
        return helper(node, arr, 0);
    }

    // Recursive helper method to check if the specified path exists in the tree
    boolean helper(TreeNode node, int[] arr, int index) {
        // If the current node is null or the index is out of bounds or the values don't match, return false
        if (node == null || index >= arr.length || node.val != arr[index]) {
            return false;
        }
        // If it's a leaf node and index is at the end of the path array, return true
        if (node.left == null && node.right == null && index == arr.length - 1) {
            return true;
        }
        // Recursively check the left and right subtree with the next index in the path array
        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }
}
