/*------------------------------------------------------------------------------------
                            APPROACH (DFS)
 -------------------------------------------------------------------------------------
    1. The goal of this problem is to check if the leaf nodes of two binary trees are similar. 
    
    2. To achieve this, we can perform a depth-first traversal of each tree and collect the leaf values into separate lists. 
    
    3. After collecting the leaf values for both trees, we can compare the lists to determine if they are leaf-similar.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Main function to check if two trees are leaf-similar
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Lists to store leaf values for each tree
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Collect leaf values for the first tree
        findLeaves(root1, leaves1);

        // Collect leaf values for the second tree
        findLeaves(root2, leaves2);

        // Compare the lists of leaf values
        return leaves1.equals(leaves2);
    }

    // Helper function to recursively find and collect leaf values
    public void findLeaves(TreeNode root, List<Integer> leaves) {
        // Base case: if the current node is null, return
        if (root == null) {
            return;
        }

        // If the current node is a leaf, add its value to the list
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        // Recursively traverse the left and right subtrees
        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }
}

/*-----------------------------------------------------------------------------------
                        COMPLEXITY ANALYSIS
 ------------------------------------------------------------------------------------
    - Time Complexity: O(m + n), where m, n are the total number of nodes in both trees
    - Space Complexity: O(m + n), the space used in storing the leaf values.
 */