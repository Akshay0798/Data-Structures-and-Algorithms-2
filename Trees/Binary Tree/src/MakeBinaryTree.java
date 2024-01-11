import java.util.Scanner;

class MakeBinaryTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // insert elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value + "? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            if (isValueAlreadyPresent(value)) {
                System.out.println("Value already exists. Please enter a different value.");
                populate(scanner, node); // Ask again for left subtree
            } else {
                node.left = new Node(value);
                populate(scanner, node.left);
            }
        }

        System.out.println("Do you want to enter right of " + node.value + "? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            if (isValueAlreadyPresent(value)) {
                System.out.println("Value already exists. Please enter a different value.");
                populate(scanner, node); // Ask again for right subtree
            } else {
                node.right = new Node(value);
                populate(scanner, node.right);
            }
        }
    }

    private boolean isValueAlreadyPresent(int value) {
        return isValueAlreadyPresent(root, value);
    }

    private boolean isValueAlreadyPresent(Node node, int value) {
        // Base case: If the current node is null (i.e., the subtree is empty), the value is not found,
        // so return false.
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;  // If the value matches the current node's value, we found the value in the tree, so return true.
        }
        return isValueAlreadyPresent(node.left, value) || isValueAlreadyPresent(node.right, value);
    }
//------------------------------------------------------------------------------------------------------------------------------

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

//---------------------------------------------------------------------------------------------------------------------

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

//------------------------------------------------------------------------------------------------------------------

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
//---------------------------------------------------------------------------------------------

    public void inOrder() {
        preOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }
//---------------------------------------------------------------------------------------------
    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }
}
