class Solution {
    public double myPow(double x, int n) {
        
        long power = n; // use long to handle Integer.MIN_VALUE
        
        // If exponent is negative
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1;

        // Binary Exponentiation
        while (power > 0) {

            // If power is odd
            if (power % 2 == 1) {
                result *= x;
            }

            x *= x;
            power /= 2;
        }

        return result;
    }
}