/* ------------------------------------------------------------------------------------
                        APPROACH - 3 (Bit Manipulation)
-------------------------------------------------------------------------------------
*/
class Solution {
    static int singleElement(int[] arr , int N) {
        int ones = 0; // Bits that have appeared once
        int twos = 0; // Bits that have appeaerd twice
        
        for (int a : arr) {
            // Update 'ones' using XOR and bitwise operations
            // XOR with bits in 'a' that have not appeared in 'twos'
            ones ^= (a & ~twos);

            // Update 'twos' using XOR and bitwise operations
            // XOR with bits in 'a' that have not appeared in 'ones'
            twos ^= (a & ~ones);
        }

        // The final value of 'ones' represents the bits of the element that appears only once
        return ones;
    }
}


/*------------------------------------------------------------------------------------
                                COMPLEXITY ANALYSIS
 -------------------------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(1)
 */