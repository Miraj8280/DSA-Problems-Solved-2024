/* ---------------------------------------------------------------------------------
                                COMPANY TAGS
 ------------------------------------------------------------------------------------
    - Paytm
 */

/* -----------------------------------------------------------------------------------
                            APPROACH (SLIDING WINDOW)
 ------------------------------------------------------------------------------------
    1. We maintain counts for each of the characters '0', '1', and '2' and use two pointers, left and right, to define a sliding window in the string.

    2. We iterate through the string while moving the right pointer. At each step, we update the counts based on the character at the right pointer.

    3. Whenever the counts of '0', '1', and '2' are all greater than 0, it means we have found a valid substring. We then move the left pointer to minimize the window while still maintaining the condition of having all three characters.

    4. While minimizing the window, we update the minimum length of the substring if we find a smaller valid substring.

    5. We continue this process until we reach the end of the string.

    6. Finally, we check if the minimum length has been updated. If it is still the initial value (Integer.MAX_VALUE), it means no valid substring was found, and we return -1. Otherwise, we return the minimum length.
 */

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int count0 = 0; // Counts for 0
        int count1 = 0; // Counts for 1
        int count2 = 0; // Counts for 2
        int minLength = Integer.MAX_VALUE; // Minimum length of the substring

        // Pointers for the sliding window
        int left = 0;
        int right = 0;
        
        // Iterating through the string while moving the right pointer
        while (right < S.length()) {
            // Counting 0s, 1s, and 2s
            if (S.charAt(right) == '0') {
                count0++;
            }
            else if (S.charAt(right) == '1') {
                count1++;
            }
            else {
                count2++;
            }
            
            // Minimizing the sliding window by moving the left pointer
            while (count0 > 0 && count1 > 0 && count2 > 0) {
                if (S.charAt(left) == '0') {
                    count0--;
                }
                else if (S.charAt(left) == '1') {
                    count1--;
                }
                else {
                    count2--;
                }
                
                minLength = Math.min(minLength, right - left + 1);
                
                left++;
            }
            
            right++;
        }
        
        // If the minLength is still Integer.MAX_VALUE, then no valid string was found
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
/*------------------------------------------------------------------------------------
                                COMPLEXITY ANALYSIS
 -------------------------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(1)
 */