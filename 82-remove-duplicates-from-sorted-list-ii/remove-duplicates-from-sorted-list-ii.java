/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Check duplicates
            if (current.next != null &&
                current.val == current.next.val) {

                // Skip all duplicate nodes
                while (current.next != null &&
                       current.val == current.next.val) {

                    current = current.next;
                }

                // Remove duplicates
                prev.next = current.next;

            } else {

                // Move prev only if no duplicate
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }
}