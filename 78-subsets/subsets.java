import java.util.*;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(0, nums, new ArrayList<>());

        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current) {

        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}