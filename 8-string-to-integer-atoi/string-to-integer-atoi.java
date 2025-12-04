class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        if (n == 0) return 0;

        // Step 1: Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If only spaces
        if (i == n) return 0;

        // Step 2: Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        long ans = 0; // Use long to detect overflow while calculating

        // Step 3: Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0');

            // Step 4: Check overflow and clamp
            if (sign == 1 && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(ans * sign);
    }
}
