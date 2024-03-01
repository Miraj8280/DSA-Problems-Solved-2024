import java.util.HashMap;
import java.util.Map;
/* ------------------------------------------------------------------------------------
                        APPROACH - 2(HashMap)
-------------------------------------------------------------------------------------
*/
class Solution {
    static int singleElement(int[] arr , int N) {
        int single = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                single = entry.getKey();
            }
        }
        
        return single;
    }
}

/*------------------------------------------------------------------------------------
                                COMPLEXITY ANALYSIS
 -------------------------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(n)
 */