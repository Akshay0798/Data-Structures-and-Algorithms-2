import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {
    // TreeNode class for the binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructors for TreeNode class
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

    // Serialize method to convert a binary tree to a string
    public String serialize(TreeNode root) {
        if (root == null) {
            return ""; // If the root is null, return an empty string
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Create a queue to perform level order traversal
        StringBuilder result = new StringBuilder(); // StringBuilder to store the serialized tree
        queue.add(root); // Add the root to the queue

        // Perform level order traversal using the queue
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Dequeue the node

            if (node == null) {
                result.append("null "); // If the node is null, add "null" to the result
            } else {
                result.append(node.val).append(" "); // Add the node's value to the result
                queue.add(node.left); // Enqueue the left child
                queue.add(node.right); // Enqueue the right child
            }
        }
        return result.toString().trim(); // Return the serialized tree as a string
    }

    // Deserialize method to reconstruct a binary tree from the string
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null; // If the data is empty, return null
        }

        String[] values = data.split(" "); // Split the serialized string by space
        Queue<TreeNode> nodes = new LinkedList<>(); // Queue to reconstruct the tree nodes
        TreeNode root = new TreeNode(Integer.parseInt(values[0])); // Create the root node
        nodes.add(root); // Add the root node to the queue

        // Reconstruct the tree based on the serialized data
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = nodes.poll(); // Dequeue a node as a parent

            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i])); // Create left child
                parent.left = left; // Assign left child to the parent node
                nodes.add(left); // Add the left child to the queue
            }

            if (++i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i])); // Create right child
                parent.right = right; // Assign right child to the parent node
                nodes.add(right); // Add the right child to the queue
            }
        }
        return root; // Return the reconstructed tree
    }
}
