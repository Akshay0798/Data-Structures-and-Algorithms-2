public class Print_In_Range {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data > x) {
            printInRange(root.left, x, y);
        }
        if (root.data >= x && root.data <= y) {
            System.out.print(root.data + " ");
        }
        if (root.data < y) {
            printInRange(root.right, x, y);
        }
    }

    public static void main(String[] args) {
        // Create an array of integer values to be inserted into the BST
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // Create a variable 'root' to represent the root of the Binary Search Tree
        Node root = null;
        // Insert each value from the 'values' array into the BST using the 'insert' method
        for (int val : values) {
            root = insert(root, val);
        }
        System.out.print("In-order traversal of the BST: ");
        inOrder(root);
        System.out.println();
        System.out.print("Elements within the range : ");
        printInRange(root, 4, 8);
    }
}
