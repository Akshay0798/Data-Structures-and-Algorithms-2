import java.util.LinkedList;
import java.util.Queue;
@SuppressWarnings("ALL")

public class BinaryTree1 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    //for root element we make buildTree function
    static class BinaryTree{
        static int idx = -1; //this is for traversal of nodes
        public static Node buildTree(int[] nodes){ //it will return root node
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }
    //-------------------------------------------------------------------------------------
    public static void preOrder(Node root){ //root pahile hi aata he
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //--------------------------------------------------------------------------------------
    public static void InOrder(Node root){
        if (root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
    //--------------------------------------------------------------------------------------
    public static void PostOrder(Node root){
        if (root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");

    }
    //--------------------------------------------------------------------------------------

    //    TC:O(n)-linear time complexity
    public static void LevelOrder(Node root) {
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){ //jab tak queue khali nahi hoti hum loop chalange
            Node currNode = queue.remove(); //as such,1st node khali kar diya queue se
            if (currNode == null){
                System.out.println(); //next line
                if (queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if (currNode.left != null){
                    queue.add(currNode.left);
                }
                if (currNode.right != null){
                    queue.add(currNode.right);
                }
            }
        }
    }
    //--------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

//        preOrder(root);
//        System.out.println();

//        InOrder(root);
//        System.out.println();

//        PostOrder(root);
//        System.out.println();

        LevelOrder(root);
    }
}
