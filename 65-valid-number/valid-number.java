class Solution {
    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Digit
            if (Character.isDigit(ch)) {
                seenDigit = true;
            }

            // Sign
            else if (ch == '+' || ch == '-') {

                // Sign is valid only at start
                // or immediately after e/E
                if (i > 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            // Decimal point
            else if (ch == '.') {

                // Dot cannot appear after exponent
                // or more than once
                if (seenDot || seenExponent) {
                    return false;
                }

                seenDot = true;
            }

            // Exponent
            else if (ch == 'e' || ch == 'E') {

                // Exponent must appear once
                // and only after a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }

                seenExponent = true;

                // Need digit after exponent
                seenDigit = false;
            }

            // Invalid character
            else {
                return false;
            }
        }

        return seenDigit;
    }
}