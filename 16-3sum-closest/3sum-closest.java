import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2]; // initial guess

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If this sum is closer to target, update it
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;      // need a larger sum
                } else if (sum > target) {
                    right--;     // need a smaller sum
                } else {
                    return sum;  // exact match → best possible
                }
            }
        }
        return closest;
    }
}

