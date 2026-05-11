import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        // base case: empty tree
        if (start > end) {
            res.add(null);
            return res;
        }

        // try every number as root
        for (int i = start; i <= end; i++) {

            List<TreeNode> leftTrees = build(start, i - 1);
            List<TreeNode> rightTrees = build(i + 1, end);

            // combine left and right
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}