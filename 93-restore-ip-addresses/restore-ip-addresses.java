import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        // If 4 parts formed
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            // Check validity
            if (isValid(part)) {
                path.add(part);
                backtrack(s, index + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        // leading zero case
        if (s.length() > 1 && s.startsWith("0")) return false;

        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}