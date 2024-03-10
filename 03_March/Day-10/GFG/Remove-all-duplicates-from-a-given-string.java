import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    String removeDuplicates(String str) {
        String result = "";
        Set<Character> set = new LinkedHashSet<>();
        
        for (Character ch : str.toCharArray()) {
            set.add(ch);
        }
        
        for (Character ch : set) {
            result += ch;
        }
        
        return result;
    }
}