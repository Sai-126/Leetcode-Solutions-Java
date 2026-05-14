class Solution {
    public String reverseWords(String s) {
        // Step 1: trim and split by multiple spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: reverse and build result
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}