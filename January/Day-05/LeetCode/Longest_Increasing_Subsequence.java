class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int i = 0;
            int j = size;

            while (i != j) {
                int k = (i + j) / 2;
                if (tails[k] < num) {
                    i = k + 1;
                }
                else {
                    j = k;
                }
            }

            tails[i] = num;
            if (i == size) {
                size++;
            }
        }

        return size;
    }
}