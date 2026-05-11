import java.util.*;

class Solution {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            // Current height
            int currentHeight =
                    (i == heights.length) ? 0 : heights[i];

            // Maintain increasing stack
            while (!stack.isEmpty() &&
                   currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                // Width calculation
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}