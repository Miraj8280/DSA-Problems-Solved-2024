class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long sum = 0;
        
        for(long i = a; i <= b; i++){
            sum += primeFactors(i);
        }
        
        return sum;
    }
    
    
    public static long primeFactors(long n){
        long count = 0;
        
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }
        
        if (n > 2) count++;
        
        return count;
    }
}