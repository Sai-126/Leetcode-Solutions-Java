class Solution {
    public int maxTwoEvents(int[][] events) {

        // Sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        // suffixMax[i] = maximum value from i to n-1
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            int currentEnd = events[i][1];
            int currentValue = events[i][2];

            // Binary search for next non-overlapping event
            int low = i + 1;
            int high = n - 1;
            int nextIndex = -1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                // Non-overlapping condition
                if (events[mid][0] > currentEnd) {
                    nextIndex = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            int total = currentValue;

            if (nextIndex != -1) {
                total += suffixMax[nextIndex];
            }

            answer = Math.max(answer, total);
        }

        return answer;
    }
}