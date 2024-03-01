import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution
{
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        // code here
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        solve(root, sum, sol, new LinkedList<>());
        return sol;
    }
    
    private static void solve(Node root, int sum, ArrayList<ArrayList<Integer>> sol,
                List<Integer> currSol){
        if(root == null)
            return;
        
        currSol.add(root.data);
        
        sum-= root.data;
        if(sum == 0){
            sol.add(new ArrayList<>(currSol));
        }
        
        solve(root.left, sum, sol, currSol);
        solve(root.right, sum, sol, currSol);
        currSol.remove(currSol.size()-1);
    }
}