public class CousinBT {
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

    // Method to check if two nodes are cousins in the binary tree
    public boolean isCousins(TreeNode root, int x, int y) {
        // Check if the tree is empty
        if (root == null) {
            return false; // No nodes, so they can't be cousins
        }

        // Find the nodes with values 'x' and 'y' in the tree
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        // If either 'x' or 'y' is not found in the tree, they can't be cousins
        if (xx == null || yy == null) {
            return false;
        }

        // Calculate the level (depth) of nodes 'x' and 'y'
        int levelX = level(root, xx, 0);
        int levelY = level(root, yy, 0);

        // Check if 'x' and 'y' are at the same level and not siblings
        return (levelX == levelY) && (!isSibling(root, xx, yy));
    }

    // Recursive method to find a node with a given value 'x' in the tree
    private TreeNode findNode(TreeNode node, int x) {
        // If the current node is null, return null (node not found)
        if (node == null) {
            return null;
        }
        // If the current node's value is equal to 'x', return the node
        if (node.val == x) {
            return node;
        }
        // Otherwise, recursively search in the left and right subtrees
        TreeNode leftResult = findNode(node.left, x);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(node.right, x);
    }

    // Recursive method to check if two nodes are siblings
    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        // If the current node is null, they can't be siblings
        if (node == null) {
            return false;
        }

        // Check if 'x' and 'y' are siblings of the current node
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSibling(node.left, x, y) || isSibling(node.right, x, y));
    }

    // Recursive method to calculate the level (depth) of a node with value 'x'
    private int level(TreeNode node, TreeNode x, int lev) {
        // If the current node is null, the node was not found at this branch, so return 0 (not found)
        if (node == null) {
            return 0;
        }

        // If the current node is the target node 'x', return its level
        if (node == x) {
            return lev;
        }

        // Recursively search for 'x' in the left and right subtrees, incrementing the level
        int leftLevel = level(node.left, x, lev + 1);
        if (leftLevel != 0) {
            return leftLevel;
        }
        return level(node.right, x, lev + 1);
    }
}

/*
((node.left == x && node.right == y) || (node.left == y && node.right == x)
|| isSibling(node.left, x, y) || isSibling(node.right, x, y))

This code checks if two nodes (x and y) in a binary tree are siblings or not. Siblings are nodes that share the same parent.
        node.left == x && node.right == y: It checks if x is on the left and y is on the right of the current node (node).
        node.left == y && node.right == x: It checks the opposite, if y is on the left and x is on the right.
        These two checks handle cases where x and y are immediate children of the same parent.

        isSibling(node.left, x, y): It checks if x and y are siblings in the left subtree.
        isSibling(node.right, x, y): It checks if x and y are siblings in the right subtree.
        These two recursive calls handle cases where x and y are not immediate children but could be siblings in different subtrees.

        If any of these conditions are true, the method returns true, indicating that x and y are siblings. Otherwise, it returns false.
*/
