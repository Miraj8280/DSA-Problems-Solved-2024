import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, 1 + map.getOrDefault(a, 0));
        }
        
        return map.size() == new HashSet<>(map.values()).size();
    }
}