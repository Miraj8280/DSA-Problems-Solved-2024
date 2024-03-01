/* ---------------------------------------------------------------------------------
                                COMPANY TAGS
 ------------------------------------------------------------------------------------
    - Facebook
    - Paytm
    - Myntra
 */

/* -----------------------------------------------------------------------------------
                            APPROACH (SLIDING WINDOW)
 ------------------------------------------------------------------------------------
    1. Calculate the sum of the first k elements in the array and store it in the variable ksum. This is the sum of the initial window of size k.

    2. Set both maxSum and sum to the initial value of ksum. These variables will be used to keep track of the maximum sum encountered so far and the current sum of the sliding window.

    3. Iterate through the array starting from index k to the end.

        i) At each step, update ksum by adding the current element and subtracting the element that is no longer part of the window (i.e., the element k positions behind the current one).

        ii) Update sum by taking the maximum of either the current sum plus the current element or the updated ksum. This ensures that sum represents the maximum sum of the current subarray.

        iii) Update maxSum with the maximum of the current sum and the previous maxSum. This ensures that maxSum always contains the largest sum encountered so far.

    4. After iterating through the entire array, the variable maxSum will contain the largest sum of a subarray containing at least k numbers. Return this value as the final result.
 */
class Solution {
    
    public long maxSumWithK(long a[], long n, long k) {
        long ksum = 0;
        
        for (int i = 0; i < k; i++) {
            ksum += a[i];
        }
        
        long maxSum = ksum;
        long sum = ksum;
        
        for (int i = (int)k; i < n; i++) {
            ksum += a[i] - a[i - (int)k];
            sum = Math.max(sum + a[i], ksum);
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

/* -----------------------------------------------------------------------------------
                            COMPLEXITY ANALYSIS
--------------------------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(1)
*/