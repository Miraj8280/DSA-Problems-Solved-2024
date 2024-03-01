import java.util.Queue;
import java.util.Stack;

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < k; i++) {
            int item = q.poll();
            stack.push(item);
        }
        
        while (!stack.empty()) {
            int item = stack.pop();
            q.add(item);
        }
        
        for (int i = 0; i < q.size() - k; i++) {
            int item = q.poll();
            q.add(item);
        }
        
        return q;
    }
}