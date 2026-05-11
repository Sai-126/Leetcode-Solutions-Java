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

    public ListNode partition(ListNode head, int x) {

        // Dummy heads
        ListNode smallerDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode smaller = smallerDummy;
        ListNode greater = greaterDummy;

        while (head != null) {

            // Node less than x
            if (head.val < x) {

                smaller.next = head;
                smaller = smaller.next;

            } else {

                // Node greater or equal to x
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // End second list
        greater.next = null;

        // Connect two lists
        smaller.next = greaterDummy.next;

        return smallerDummy.next;
    }
}