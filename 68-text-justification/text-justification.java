import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int lineLength = words[i].length();
            int j = i + 1;

            // Find how many words fit in current line
            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {

                lineLength += 1 + words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Last line OR single word → left justify
            if (j == words.length || gaps == 0) {

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                // Fill remaining spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Fully justify
                int totalChars = 0;

                for (int k = i; k < j; k++) {
                    totalChars += words[k].length();
                }

                int totalSpaces = maxWidth - totalChars;

                int spaces = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        // Add evenly distributed spaces
                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }

                        // Extra spaces go to left slots
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}