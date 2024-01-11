public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if (root == null){
            root = new Node(val);
            return root;
        }
        if (root.data > val){
            //left subTree
            root.left = insert(root.left, val);
        }
        else {
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    //checking its in order or not
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
//---------------------------------------------------------------------------
    public static boolean search(Node root, int key){
        if (root == null){
            return false;
        }
        if (root.data > key){
            return search(root.left,key);
        }
        else if (root.data == key) {
            return true;
        }
        else {
            return search(root.right,key);  //root.data < key
        }
    }
//----------------------------------------------------------------------------

    public static Node delete(Node root,int val){
        if (root == null) {
            return null;
        }
        // If the value to be deleted is smaller, go to the left subtree.
        else if (root.data > val){
            root.left = delete(root.left,val);
        }
        // If the value to be deleted is greater, go to the right subtree.
        else if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else { //root.data == val
            // Case 1: Node with no child (a leaf node)
            if (root.left == null && root.right == null){
                return null;
            }
            // Case 2: Node with only one child (either left or right)
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            //case 3:Node with two children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    private static Node inorderSuccessor(Node root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
//-------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root,values[i]);
        }
        inOrder(root);
        System.out.println();

        if (search(root,15)){
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }

        delete(root,15);
        inOrder(root);
    }
}
