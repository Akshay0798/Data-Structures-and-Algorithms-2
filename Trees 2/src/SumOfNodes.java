public class SumOfNodes {
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
        static int idx = -1; // this is for traversal of nodes

        public Node buildTree(int[] nodes) { // it will return root node
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

    public static int SumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = SumNodes(root.left);
        int rightSum = SumNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        int sum = SumNodes(root);
        System.out.println("Sum of all nodes: " + sum);
//        TC:O(n);
    }
}
