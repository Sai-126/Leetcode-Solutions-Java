class Solution {
    public int removeDuplicates(int[] nums) {

        // If array size <= 2, already valid
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;

        // Start from third element
        for (int i = 2; i < nums.length; i++) {

            // Keep element only if it is not
            // same as element two positions back
            if (nums[i] != nums[index - 2]) {

                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}