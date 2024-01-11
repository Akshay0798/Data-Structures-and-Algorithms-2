public class BinarySearchTree {

    // Node class representing individual nodes of the Binary Search Tree
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height; // Height of the node (used for balancing)

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root; // Root node of the Binary Search Tree

    public BinarySearchTree() {
        // Constructor for creating an empty Binary Search Tree
    }

    // Method to calculate the height of a given node
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // Method to check if the Binary Search Tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Method to insert a new value into the Binary Search Tree
    public void insert(int value) {
        root = insert(value, root);
    }

    // Recursive helper method to insert a new value into the Binary Search Tree
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1; // Update the height of the current node
        return node;
    }

    // Method to populate the Binary Search Tree with an array of values
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // Method to populate the Binary Search Tree with a sorted array of values
    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    // Recursive helper method to populate the Binary Search Tree with a sorted array
    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]); // Insert the middle element to maintain the sorted order
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    // Method to check if the Binary Search Tree is balanced
    public boolean balanced() {
        return balanced(root);
    }

    // Recursive helper method to check if the Binary Search Tree is balanced
    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        // Check if the heights of the left and right subtrees differ by at most 1
        // and recursively check for the left and right subtrees
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    // Method to display the Binary Search Tree in pre-order traversal
    public void display() {
        display(this.root, "Root Node: ");
    }

    // Recursive helper method to display the Binary Search Tree
    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }


}
