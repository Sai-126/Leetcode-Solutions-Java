import java.util.*;

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtrack(1, n, k, new ArrayList<>());

        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current) {

        // Combination complete
        if (current.size() == k) {

            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {

            // Choose
            current.add(i);

            // Explore
            backtrack(i + 1, n, k, current);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}