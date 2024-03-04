import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int ans = 0;
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;
        
        while(left <= right) {
            // score gain, power loss
            if(tokens[left] <= power) {
                score++;
                ans = Math.max(ans, score);
                power -= tokens[left];
                left++;
            }
            // power gain, score loss
            else if(score > 0) {
                power += tokens[right];
                score--;
                right--;
            }
            else {
                break;
            }
        }
        return ans;
    }
}