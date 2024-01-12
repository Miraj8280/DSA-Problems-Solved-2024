class Solution {
    public boolean isVowel(char ch) {

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {

            return true;
        }

        return false;
    }
    
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();

        int count1 = 0; // counts first half
        int count2 = 0; // counts second half

        for(int i = 0; i < n / 2; ++i) {

            if(isVowel(s.charAt(i))) {

                count1++;
            }
        }

        for(int i = n / 2; i < n; ++i) {

            if(isVowel(s.charAt(i))) {

                count2++;
            }
        }
        
        return count1 == count2;
    }
}