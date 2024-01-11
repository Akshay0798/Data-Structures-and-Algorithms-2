import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // Main method to test the Make Binary Tree class

//        MakeBinaryTree binaryTree = new MakeBinaryTree();
//
//        Scanner scanner = new Scanner(System.in);
//        binaryTree.populate(scanner);
//        binaryTree.display();
//        binaryTree.prettyDisplay();


    // Main method to test the Binary Search Tree class

        BinarySearchTree bst = new BinarySearchTree();

        int[] numbs = { 10, 5, 20, 3, 8, 15, 25 };
        bst.populate(numbs);

        System.out.println("Original BST:");
        bst.display();

        System.out.println("Is the tree balanced? " + bst.balanced());

        BinarySearchTree bstSorted = new BinarySearchTree();
        int[] sortedNums = { 3, 5, 8, 10, 15, 20, 25 };
        bstSorted.populatedSorted(sortedNums);

        System.out.println("\nBST with sorted elements:");
        bstSorted.display();

        System.out.println("Is the sorted tree balanced? " + bstSorted.balanced());
    }
}

