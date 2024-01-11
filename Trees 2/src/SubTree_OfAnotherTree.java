//https://leetcode.com/problems/subtree-of-another-tree/
public class SubTree_OfAnotherTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static TreeNode constructTreeFromArray(int[] nodes, int[] index) {
        int value = nodes[index[0]];
        index[0]++;

        if (value == -1) {
            return null;
        }

        TreeNode node = new TreeNode(value);
        node.left = constructTreeFromArray(nodes, index);
        node.right = constructTreeFromArray(nodes, index);

        return node;
    }
    public static void main(String[] args) {
        // Example test cases
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        boolean result1 = isSubtree(root1, root2);
        System.out.println("Is root2 a subtree of root1? " + result1);
    //---------------------------------------------------------------------------
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(0);


        boolean result2 = isSubtree(root1, root3);
        System.out.println("Is root3 a subtree of root1? " + result2);

    }
}