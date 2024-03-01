import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            if (!set.add(Arrays.hashCode(matrix[i]))) {
                arr.add(i);
            }
        }
        
        return arr;
    }
}
