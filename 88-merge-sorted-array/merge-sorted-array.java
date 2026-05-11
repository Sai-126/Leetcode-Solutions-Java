class Solution {

    public void merge(int[] nums1, int m,
                      int[] nums2, int n) {

        // Pointers for nums1, nums2, and end position
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge from back
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];
                i--;

            } else {

                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining nums2 elements
        while (j >= 0) {

            nums1[k] = nums2[j];

            j--;
            k--;
        }
    }
}