@SuppressWarnings("ALL")
public class HeightOfTree {
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

    public static int Height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static int Diameter(Node root){
        if (root == null) {
            return 0;
        }
        int diam1=Diameter(root.left);
        int diam2=Diameter(root.right);
        int diam3=Height(root.left) + Height(root.right) + 1;

        int myDiameter =  Math.max(diam3,Math.max(diam1,diam2));
        return myDiameter;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int height = Height(root);
        System.out.println("Height of the tree: " + height);

        int Diameter = Diameter(root); //TC:O(n2)
        System.out.println("Diameter of the tree: " + Diameter);



    }
}
