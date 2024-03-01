import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    boolean check(Node root) {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int lasth = -1;
        int h = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }

                if (n.left == null && n.right == null) {
                    if (lasth == -1) {
                        lasth = h;
                    } else if (lasth != h) {
                        return false;
                    }
                }
            }
            h++;

        }
        return true;
    }
}