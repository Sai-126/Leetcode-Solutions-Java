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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = prevGroupEnd;
            // Find the k-th node
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // Less than k nodes left

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // Reverse the group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect previous group
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}
