/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten left and right subtree
        flatten(root.left);
        flatten(root.right);

        // Store right subtree
        TreeNode tempRight = root.right;

        // Move left subtree to right
        root.right = root.left;
        root.left = null;

        // Find end of new right subtree
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }

        // Attach original right subtree
        curr.right = tempRight;
    }
}