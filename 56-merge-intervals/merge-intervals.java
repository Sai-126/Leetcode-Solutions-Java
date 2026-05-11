import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Start with first interval
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            // Overlapping intervals
            if (intervals[i][0] <= current[1]) {

                // Merge intervals
                current[1] = Math.max(current[1], intervals[i][1]);

            } else {

                // No overlap → add current interval
                result.add(current);

                // Move to next interval
                current = intervals[i];
            }
        }

        // Add last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}