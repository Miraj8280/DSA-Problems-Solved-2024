import java.util.Arrays;
/* ------------------------------------------------------------------------------------
                        APPROACH - 1(SORTING)
-------------------------------------------------------------------------------------
*/
class Solution {
    static int singleElement(int[] arr , int N) {
        // Sorting the given array
        Arrays.sort(arr);
        
        // Iterating through the array by incrementing the index by 3 as all elements are repeated three times except one.
        for (int i = 0; i < N; i += 3) {
            if (i < N - 2 && arr[i] != arr[i + 2]) {
                return arr[i];
            }
        }
        
        return arr[N - 1];
    }
}