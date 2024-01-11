
@SuppressWarnings("ALL")

public class BinaryTreeDiameter {

    // Node class to represent a node in the binary tree
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

    // BinaryTree class to build the binary tree from the given level-order traversal
    static class BinaryTree {
        static int idx = -1; // This is for traversal of nodes

        public static Node buildTree(int[] nodes) { // It will return root node
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // TreeInfo class to store height and diameter of the subtree
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Function to calculate the diameter of the binary tree using recursion
    public static TreeInfo diameter(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        // Recursively calculate height and diameter of the left and right subtrees
        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        // Calculate the height
        int myHeight = Math.max(left.height, right.height) + 1;

        // Calculate three possible diameters
        int diam1 = left.diameter;   // 1. Diameter of the left subtree
        int diam2 = right.diameter;  // 2. Diameter of the right subtree
        // 3. Diameter passing through the current node (height of left subtree + height of right subtree + 1)
        int diam3 = left.height + right.height + 1;

        int myDiam = Math.max(Math.max(diam1, diam2), diam3);

        // Create a new TreeInfo object with the calculated height and diameter
        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Calculate the diameter of the binary tree using the diameter() function
        System.out.println("Diameter of the tree: " + diameter(root).diameter);
    }
}
