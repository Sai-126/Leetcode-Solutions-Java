class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // both null → same
        if (p == null && q == null) return true;

        // one null → different
        if (p == null || q == null) return false;

        // value mismatch
        if (p.val != q.val) return false;

        // check left and right
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}