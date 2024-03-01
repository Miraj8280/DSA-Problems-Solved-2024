/* ----------------------------------------------------------------------------------
                        APPROACH (DP)
 ------------------------------------------------------------------------------------
    1. Create a 2D array jobs to store the information about each job: start time, end time, and profit.

    2. Sort the jobs array based on the end times of the jobs in ascending order.

    3. Create a TreeMap dp to store the maximum profit at each time point. The TreeMap is used for efficient floor entry lookup.

    4. Initialize dp with a single entry where time is 0 and profit is 0.

    5. Iterate through each job in the sorted jobs array:

        a. Find the floor entry in dp for the current job's start time (job[0]). The floor entry is the largest key less than or equal to the given key.

        b. Calculate the profit for the current job by adding the profit of the current job to the profit obtained at or before its start time.

        c. Check if the calculated profit (cur) is greater than the last entry in dp. If true, update the dp with the end time of the current job and the calculated profit.

    6. Finally, return the maximum profit obtained, which is the profit stored in the last entry of the TreeMap.
 */

import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int curr = dp.floorEntry(job[0]).getValue() + job[2];
            
            if (curr > dp.lastEntry().getValue()) {
                dp.put(job[1], curr);
            }
        }

        return dp.lastEntry().getValue();
    }
}