public class ConvertSortedArrToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        // Initialize the start and end indices for the input array
        int startIndex = 0;
        int endIndex = nums.length - 1;

        // Call the helper function to construct the Binary Search Tree
        return constructBSTFromSortedArray(nums, startIndex, endIndex);
    }

    // Helper function to construct a Binary Search Tree from a sorted array
    public TreeNode constructBSTFromSortedArray(int[] sortedArray, int startIndex, int endIndex) {
        // Base case: If the start index is greater than the end index, return null (empty subtree)
        if (startIndex > endIndex) {
            return null;
        }

        // Calculate the middle index to find the root node of the current subtree
        int midIndex = (startIndex + endIndex) / 2;

        // Create a new TreeNode with the value at the middle index
        TreeNode root = new TreeNode(sortedArray[midIndex]);

        // Recursively build the left subtree with elements before the middle index
        root.left = constructBSTFromSortedArray(sortedArray, startIndex, midIndex - 1);

        // Recursively build the right subtree with elements after the middle  index
        root.right = constructBSTFromSortedArray(sortedArray, midIndex + 1, endIndex);


        return root;
    }

}
