import java.util.HashMap;
import java.util.Map;

/*-------------------------------------------------------------------------------------
                                    APPROACH
 --------------------------------------------------------------------------------------
    1. It uses a map mp to calculate the frequency of each number in nums.

    2. If any number occurs only once in nums, it's impossible to achieve the desired pattern, so the function returns -1.

    3. It calculates the number of moves needed to make all occurrences of each number a multiple of 3. If there are remaining occurrences (not divisible by 3), it adds one more move for each such occurrence.

    4. Finally, it returns the total number of moves needed to achieve the desired pattern.
 */

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int operations = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();

            if (frequency == 1) {
                return -1;
            }

            operations += frequency / 3;

            if (frequency % 3 != 0) {
                operations++;
            }
        }

        return operations;
    }
}

/*------------------------------------------------------------------------------------
                                COMPLEXITY ANALYSIS
 -------------------------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(n)
 */