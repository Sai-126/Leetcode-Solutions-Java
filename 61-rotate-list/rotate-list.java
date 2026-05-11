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
    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length of list
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Reduce unnecessary rotations
        k = k % length;

        // If no rotation needed
        if (k == 0) {
            return head;
        }

        // Make circular linked list
        tail.next = head;

        // Find new tail
        int stepsToNewTail = length - k;

        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}