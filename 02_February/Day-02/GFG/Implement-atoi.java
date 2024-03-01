class Solution
{
    int atoi(String s) {
	    // Your code here
	    int result = 0;
        int sign = 1;
        
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
            
                result = result * 10 + (ch - '0');
            } else {
                return -1;
            }
        }
        
        return sign * result;
    }
}