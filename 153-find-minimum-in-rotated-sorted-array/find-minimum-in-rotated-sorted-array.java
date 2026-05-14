class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid is greater than high, min is in right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // else min is in left half including mid
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}