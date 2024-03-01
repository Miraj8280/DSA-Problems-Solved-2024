import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalSubsequences = 0;

        // dp array to store the number of subsequences ending at index i with a
        // specific difference
        Map<Long, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                // Calculate the difference between nums[i] and nums[j] using long
                long diff = (long) nums[i] - nums[j];

                // Get the count of subsequences ending at index j with the same difference
                int count = dp[j].getOrDefault(diff, 0);

                // Add the count to the total number of subsequences
                totalSubsequences += count;

                // Update the count for subsequences ending at index i with the same difference
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
            }
        }

        return totalSubsequences;
    }
}