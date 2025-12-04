class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindrome
        // Also numbers ending with 0 but not 0 itself (e.g., 10, 100)
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int reversedHalf = 0;

        // Reverse only half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For odd length numbers: reversedHalf/10 removes the middle digit
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
