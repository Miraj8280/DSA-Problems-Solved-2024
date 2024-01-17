import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
         // Using a set to ensure uniqueness
        Set<ArrayList<Integer>> uniquePermsSet = new HashSet<>();

        // Generate permutations and add them to the set
        permute(arr, 0, n, uniquePermsSet);

        // Convert the set to a list and sort
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(uniquePermsSet);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    int cmp = Integer.compare(o1.get(i), o2.get(i));
                    if (cmp != 0) return cmp;
                }
                return Integer.compare(o1.size(), o2.size());
            }
        });

        return result;
    }

    private static void permute(ArrayList<Integer> arr, int index, int n, Set<ArrayList<Integer>> set) {
        if (index == n) {
            set.add(new ArrayList<>(arr)); // Add a copy of the current permutation
            return;
        }

        for (int i = index; i < n; i++) {
            Collections.swap(arr, i, index); // Swap the elements
            permute(arr, index + 1, n, set); // Recurse for the next element
            Collections.swap(arr, i, index); // Swap back
        }
    }
};