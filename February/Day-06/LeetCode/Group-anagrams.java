import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store anagrams, where the key is the unique representation of string and the value is a list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input string array
        for (String str : strs) {
            // Create a key based on the character count of the string
            String key = generateKey(str);

            // If the key is not in the map, add it with an empty list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original string to the list associated with the key
            map.get(key).add(str);
        }

        // Return the lists of anagrams
        return new ArrayList<>(map.values());
    }

    // Sort characters of a string
    private String generateKey(String str) {
        // Initialize an array to store the count of each character
        int[] count = new int[26];
        
        // Increment the count for each character in the word
        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }

        // Create a key by concatenating the count of each character
        StringBuilder keyBuilder = new StringBuilder();
        for (int cnt : count) {
            keyBuilder.append(cnt).append('$');
        }

        // Return the generated key as an string
        return keyBuilder.toString();
    }
}