import java.util.*;

class Solution {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        // Same string
        if (s1.equals(s2)) {
            return true;
        }

        // Different character frequencies
        if (!hasSameCharacters(s1, s2)) {
            return false;
        }

        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Try every split position
        for (int i = 1; i < n; i++) {

            // Without swap
            if (isScramble(s1.substring(0, i),
                           s2.substring(0, i)) &&

                isScramble(s1.substring(i),
                           s2.substring(i))) {

                memo.put(key, true);
                return true;
            }

            // With swap
            if (isScramble(s1.substring(0, i),
                           s2.substring(n - i)) &&

                isScramble(s1.substring(i),
                           s2.substring(0, n - i))) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean hasSameCharacters(String s1, String s2) {

        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}