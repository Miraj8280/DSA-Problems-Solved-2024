class Solution {
    /*------------------------------------------------------------
                IMP POINTS TO KEEP IN MIND
    --------------------------------------------------------------
        1. Ensure that the remainder of each element is non-negative.
        2. Check if the frequency of remainder 0 is even.
        3. Check if the frequency of each remainder i is equal to the frequency of its complement (k - i).  
    */
    public boolean canPair(int[] nums, int k) {
        // Array to store the frequency of remainders
        int[] frequency = new int[k];
        
        // Counting the frequency of remainders when divided by k
        for (int num : nums) {
            // Calculating the remainder and ensure it is non-negative
            num %= k;
            if (num < 0) {
                num += k;
            }
            
            frequency[num]++;
        }
        
        // Checking if the frequency of remainder 0 is even
        if (frequency[0] % 2 != 0) {
            return false;
        }
        
        // Checking if the frequency of each remainder i is equal to the frequency of its complement (k - i)
        for (int i = 1; i <= k / 2; i++) {
            if (frequency[i] != frequency[k - i]) {
                return false;
            }
        }
        
        // All conditions are met, so the array can be divided into pairs
        return true;
    }
}