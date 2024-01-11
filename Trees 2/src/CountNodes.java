@SuppressWarnings("ALL")
public class CountNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;// Index used for traversal of nodes in the input array

        public static Node buildTree(int[] nodes) {
            idx++;// Move to the next index in the array,every index pe traversal kar rahe he
            if (idx >= nodes.length || nodes[idx] == -1) {// Check if the index is out of bounds or the current node is null (-1)
                return null;
            }
            Node newNode = new Node(nodes[idx]); // Create a new node with the current value from the array
            newNode.left = buildTree(nodes); // Recursively build the left subtree
            newNode.right = buildTree(nodes); // Recursively build the right subtree
            return newNode; // Return the constructed node
        }
    }
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1; // 1 for the current node
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        int count = countOfNodes(root);
        System.out.println("Number of nodes: " + count);
//        TC:O(n)
    }
}
