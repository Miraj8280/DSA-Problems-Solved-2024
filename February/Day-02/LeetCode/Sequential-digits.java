import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                int curr = Integer.parseInt(str.substring(i, j));
                if (curr <= high && curr >= low) {
                    result.add(curr);
                }
            }
        }

        result.sort(null);
        return result;
    }
}
