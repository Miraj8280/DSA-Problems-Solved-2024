import java.util.ArrayList;
import java.util.List;

/*-------------------------------------------------------------------
                            APPROACH
 --------------------------------------------------------------------
    1. Initialize a List to represent the 2D matrix.
    2. Initialize an array to store the frequency of each element.
    3. Iterate through each element in the input array. 
        i) If the frequency of the current element is greater or equal to the number of rows in the matrix, add a new row to the matrix. (The rows we need is equal to the maximum frequency.)
        ii) Add the current element in the matrix corresponding to its frequency. 
        iii) Increment the frequency of the current element.
    4. Return the final matrix.
 */

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        int[] frequency = new int[nums.length + 1];

        for (int num : nums) {
            if (frequency[num] >= matrix.size()) {
                matrix.add(new ArrayList<>());
            }
            
            matrix.get(frequency[num]).add(num);
            frequency[num]++;
        }

        return matrix;
    }
}

/*-------------------------------------------------------------------
                        COMPLEXITY ANALYSIS
 --------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(n)
 */
