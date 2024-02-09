class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        int ans = check(root);
        if(ans==-1){
            return 0;
        }
        return 1;
    }
    
    public static int check(Node root){
        
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.data;
        }
        
        int l_sum = check(root.left);
        if(l_sum==-1){
            return -1;
        }
        int r_sum = check(root.right);
        if(r_sum==-1){
            return -1;
        }
        if(l_sum+r_sum==root.data){
            return root.data;
        }
        return -1;
    }
}