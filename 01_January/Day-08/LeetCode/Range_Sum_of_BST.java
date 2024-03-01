/*-----------------------------------------------------------------------------------
                            APPROACH (DFS)
 ------------------------------------------------------------------------------------
    ## Key Concept: The key concept behind solving this problem efficiently is leveraging the properties of a Binary Search Tree (BST). In a BST, for each node, all nodes in its left subtree have values less than the node's value, and all nodes in its right subtree have values greater than the node's value. This property allows us to eliminate certain subtrees from consideration based on the values of the current node and the range [low, high].

    1. Base case: If the current node is null, return 0.

    2. Traverse the BST in a recursive manner.
    
    3. At each node, check if the node's value is within the specified range ([low, high]).

    4. If the node's value is within the range, add it to the sum.
    
    5. If the node's value is greater than the lower bound (low), recursively explore the left subtree.
    
    6. If the node's value is less than the upper bound (high), recursively explore the right subtree.
    
    7. Return the accumulated sum.
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/* ----------------------------------------------------------------------------------
                            MAIN SOLUTION
 -----------------------------------------------------------------------------------*/
public class Range_Sum_of_BST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: if the current node is null, return 0
        if (root == null) {
            return 0;
        }

        // Variable to accumulate the result
        int sum = 0; 

        // Checking if the current node's value is within the specified range [low, high]
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // If the current node's value is greater than the lower bound (low), recursively exploring the left subtree
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // If the current node's value is less than the upper bound (high), recursively exploring the right subtree
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        // Returning the accumulated sum
        return sum;
    }

    /*--------------------------------------------------------------------------------
                            MAIN FUNCTION
    ---------------------------------------------------------------------------------*/
    public static void main(String[] args) {
        // Example tree:  [10, 5, 15, 3, 7, null, 18]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        root.right = new TreeNode(15, null, new TreeNode(18));

        Range_Sum_of_BST solution = new Range_Sum_of_BST();
        int low = 7;
        int high = 15;

        // Output the result of rangeSumBST
        System.out.println("Sum of values in the range [" + low + ", " + high + "]: " + solution.rangeSumBST(root, low, high));
    }
}

/* -----------------------------------------------------------------------------------
                            COMPLEXITY ANALYSIS
 -------------------------------------------------------------------------------------
    - Time Complexity: O(n) (linear).
    - Space Complexity: O(h) (height of the tree).
        # Worst-case O(n) for a skewed tree. 
        # Best-case O(log(n)) for a balanced tree.
 */