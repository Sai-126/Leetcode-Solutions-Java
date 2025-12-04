import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(result, mapping, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String[] mapping, 
                           String digits, int index, StringBuilder sb) {

        // Base case: formed one valid combination
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(result, mapping, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack step
        }
    }
}
