import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        /*--------------------------------------------------
                Approach - 1 (Sorting & Two Pointers)
        ---------------------------------------------------*/
        // Sorting the arrays in ascending order
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0; // Maximum number of the content children
        int i = 0; // Pointer for the children array (g)
        int j = 0; // Pointer for the cookies array (s)

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++; // Moving to the next child
            }

            j++; // Moving to the next cookie
        }

        return count;
    }
}