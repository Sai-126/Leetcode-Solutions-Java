class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // palindrome[i][j] = true if substring i..j is palindrome
        boolean[][] palindrome = new boolean[n][n];
        
        // cuts[i] = minimum cuts needed for substring 0..i
        int[] cuts = new int[n];
        
        for (int end = 0; end < n; end++) {
            cuts[end] = end; // maximum cuts
            
            for (int start = 0; start <= end; start++) {
                
                // Check palindrome
                if (s.charAt(start) == s.charAt(end) &&
                   (end - start <= 2 || palindrome[start + 1][end - 1])) {
                    
                    palindrome[start][end] = true;
                    
                    // No cut needed
                    if (start == 0) {
                        cuts[end] = 0;
                    } else {
                        cuts[end] = Math.min(cuts[end], cuts[start - 1] + 1);
                    }
                }
            }
        }
        
        return cuts[n - 1];
    }
}