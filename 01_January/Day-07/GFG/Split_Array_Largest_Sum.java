class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int totalSum = 0;
        int max = Integer.MIN_VALUE;
        
        for (int a : arr) {
            totalSum += a;
            max = Math.max(max, a);
        }
        
        int left = max;
        int right = totalSum;
        int ans = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(arr, mid, K)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static boolean isValid(int[] arr, int requiredSum, int k) {
        int sum = 0;
        int count = 1;
        
        for (int a : arr) {
            if (sum + a <= requiredSum) {
                sum += a;
            }
            else {
                sum = a;
                count++;
            }
        }
        
        return count <= k;
    }
};