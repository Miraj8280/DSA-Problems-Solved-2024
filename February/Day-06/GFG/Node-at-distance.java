class Node 
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class Solution
{
    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node root, int k)
    {
        // Write your code here
        int result = 0;
        result = countKDist(root, k, new int[1000], new boolean[1000], 0);
        
        return result;
    }
    
    int countKDist(Node root, int k, int[] path, boolean[] vis, int len) {
        // If the current node is null, return 0.
        if (root == null)
            return 0;

        // Add the current node's data to the path array and mark it as not visited.
        path[len] = root.data;
        vis[len] = false;
        len++;

        // If the current node is a leaf node and it is at least k distance away from the root
        // and the node at distance k from the leaf node is not already visited, mark it visited and return 1.
        if (root.left == null && root.right == null && len - k - 1 >= 0 && !vis[len - k - 1]) {
            vis[len - k - 1] = true;
            return 1;
        }

        // Recursively traverse the left and right subtrees and get the counts.
        int lt = countKDist(root.left, k, path, vis, len);
        int rt = countKDist(root.right, k, path, vis, len);

        // Return the sum of counts from left and right subtrees.
        return lt + rt;
    }

}