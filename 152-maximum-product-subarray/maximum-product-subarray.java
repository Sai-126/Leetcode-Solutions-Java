class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If negative, swap because sign flips
            if (num < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(num, maxSoFar * num);
            minSoFar = Math.min(num, minSoFar * num);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}