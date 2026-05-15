class Solution {
    public int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();

        // dp[i] = longest valid subsequence ending at column i
        int[] dp = new int[cols];

        int maxKeep = 1;

        for (int i = 0; i < cols; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                boolean valid = true;

                // Check if column j can come before column i
                for (int r = 0; r < rows; r++) {

                    if (strs[r].charAt(j) > strs[r].charAt(i)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxKeep = Math.max(maxKeep, dp[i]);
        }

        return cols - maxKeep;
    }
}