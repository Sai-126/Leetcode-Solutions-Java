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
import java.util.*;

class Solution {

    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        if (left > right) return null;

        // root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = inorderMap.get(rootVal);

        // IMPORTANT: build RIGHT first
        root.right = build(postorder, index + 1, right);
        root.left = build(postorder, left, index - 1);

        return root;
    }
}