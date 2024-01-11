import java.util.Stack;

public class DFSUsingStack {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    // Method to perform Depth-First Search traversal using a stack
    void dfsStack(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>(); // Create a stack to perform DFS
        stack.push(node); // Push the initial node to the stack

        while (!stack.isEmpty()) {
            Node removed = stack.pop(); // Pop the node from the stack
            System.out.print(removed.val + " "); // Output the value of the popped node

            // Push the right node first to explore it after the left one (because of LIFO behavior of stack)
            if (removed.right != null) {
                stack.push(removed.right);
            }
            if (removed.left != null) {
                stack.push(removed.left);
            }
        }
    }

    // Main method to demonstrate and test the DFS traversal
    public static void main(String[] args) {
        DFSUsingStack obj = new DFSUsingStack(); // Create an instance of the DFSUsingStack class

        // Create a simple binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Depth-First Search (DFS) using Stack:");
        obj.dfsStack(root); // Perform DFS traversal starting from the root
    }
}
