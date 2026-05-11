import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Map to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to char array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            // Create key from sorted characters
            String key = new String(chars);

            // Add original string to corresponding group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}