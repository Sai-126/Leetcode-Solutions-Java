class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Dutch National Flag Algorithm
        while (mid <= high) {

            // If current element is 0
            if (nums[mid] == 0) {

                swap(nums, low, mid);
                low++;
                mid++;
            }

            // If current element is 1
            else if (nums[mid] == 1) {

                mid++;
            }

            // If current element is 2
            else {

                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}