@SuppressWarnings("ALL")

public class NextRightPointer {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * Populates each node's next pointer to point to its next right node.
     * If there is no next right node, the next pointer is set to null.
     *
     * @param root The root of the perfect binary tree
     * @return The root of the modified tree
     */
    public Node populateNextRightPointers(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;

        // Traverse the tree level by level
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                // Connect the left child to the right child
                current.left.next = current.right;

                // Connect the right child to the next node's left child (if exists)
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }
            leftMost = leftMost.left; // Move to the next level's leftmost node
        }

        return root;
    }
    public static void main(String[] args) {
        NextRightPointer n = new NextRightPointer();

        // Create a perfect binary tree as an example
        Node root = n.new Node(1);
        root.left = n.new Node(2);
        root.right = n.new Node(3);
        root.left.left = n.new Node(4);
        root.left.right = n.new Node(5);
        root.right.left = n.new Node(6);
        root.right.right = n.new Node(7);

        // Populate the next pointers
        Node result = n.populateNextRightPointers(root);

        // Print the next pointers to see the result
        while (result != null) {
            Node current = result;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
            result = result.left; // Move to the next level
        }
    }
}
