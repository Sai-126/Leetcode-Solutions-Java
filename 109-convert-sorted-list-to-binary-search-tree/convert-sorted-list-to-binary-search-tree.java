/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;

        int size = getSize(head);

        return build(0, size - 1);
    }

    private int getSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private TreeNode build(int left, int right) {

        if (left > right) return null;

        int mid = left + (right - left) / 2;

        // build left subtree
        TreeNode leftChild = build(left, mid - 1);

        // root from list
        TreeNode root = new TreeNode(head.val);
        head = head.next;

        // build right subtree
        TreeNode rightChild = build(mid + 1, right);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }
}