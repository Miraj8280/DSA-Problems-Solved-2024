class Solution {
    public int numberOfBeams(String[] bank) {
        int beams = 0; // Number of beams
        int prevCount = 0; // Count of devices in the previous row

        for (String row : bank) {
            int count = 0; // Count of devices in the row

            // Count the number of devices('1's) in the row
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    count++;
                }
            }

            // Calculating the number of beams between the adjacent rows (that has atleast 1 device)
            if (count > 0) {
                beams += prevCount * count;
                prevCount = count;
            }
        }

        return beams;
    }
}
/*-------------------------------------------------------------------
                        COMPLEXITY ANALYSIS
 --------------------------------------------------------------------
    - Time Complexity: O(n)
    - Space Complexity: O(1)
 */