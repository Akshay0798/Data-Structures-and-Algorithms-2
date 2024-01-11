class AVL2 {

    // Inner class representing a node in the AVL tree
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        // Constructor to create a new node with a given value
        public Node(int value) {
            this.value = value;
        }

        // Getter method to retrieve the value of the node
        public int getValue() {
            return value;
        }
    }

    private Node root; // Root node of the AVL tree

    // Constructor to initialize an empty AVL tree
    public AVL2() {
        // This constructor is currently empty as no additional initialization is needed
    }

    // Public method to calculate the height of the entire AVL tree
    public int height() {
        return height(root);
    }

    // Private recursive method to calculate the height of a specific node
    private int height(Node node) {
        if (node == null) {
            return -1; // A null node has a height of -1
        }
        return node.height; // Return the height of the node
    }

    // Public method to insert a value into the AVL tree
    public void insert(int value) {
        root = insert(value, root);
    }

    // Private recursive method to insert a value into the AVL tree
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value); // Create a new node if the current node is null
            return node;
        }

        // Compare the value to determine whether to insert in the left or right subtree
        if (value < node.value) {
            node.left = insert(value, node.left); // Recursively insert into the left subtree
        } else if (value > node.value) {
            node.right = insert(value, node.right); // Recursively insert into the right subtree
        }

        // Update the height of the current node based on its children's heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Perform rotations if necessary to maintain balance and return the rotated node
        return rotate(node);
    }

    // Private method to perform AVL rotations for balancing
    private Node rotate(Node node) {
        // Left-heavy rotation cases
        if (height(node.left) - height(node.right) > 1) {
            if(height(node.left.left) - height(node.left.right) > 0) {
                // Left-left case: Perform a right rotation
                return rightRotate(node);
            } else if(height(node.left.left) - height(node.left.right) < 0) {
                // Left-right case: Perform a left rotation on the left child followed by a right rotation on the current node
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right-heavy rotation cases
        if (height(node.left) - height(node.right) < -1) {
            if(height(node.right.left) - height(node.right.right) < 0) {
                // Right-right case: Perform a left rotation
                return leftRotate(node);
            } else if(height(node.right.left) - height(node.right.right) > 0) {
                // Right-left case: Perform a right rotation on the right child followed by a left rotation on the current node
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node; // Return the unchanged node if no rotation is needed
    }

    // Perform a right rotation
    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        // Update heights after rotation
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c; // Return the new root of the rotated subtree
    }

    // Perform a left rotation
    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        // Update heights after rotation
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p; // Return the new root of the rotated subtree
    }

    // Display the structure of the AVL tree
    public void display() {
        display(this.root, "Root Node: ");
    }

    // Private recursive method to display the structure of the AVL tree
    private void display(Node node, String details) {
        if (node == null) {
            return; // Base case: do nothing if the node is null
        }
        System.out.println(details + node.value); // Print the current node's value
        display(node.left, "Left child of " + node.value + " : "); // Recursively display the left subtree
        display(node.right, "Right child of " + node.value + " : "); // Recursively display the right subtree
    }

    // Check if the AVL tree is empty
    public boolean isEmpty() {
        return root == null; // Return true if the root node is null, indicating an empty tree
    }

}
