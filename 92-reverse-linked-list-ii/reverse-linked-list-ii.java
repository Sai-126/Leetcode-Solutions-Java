class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // 1. Move prev to node before left
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2. Start reversing
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode tail = curr; // will become tail after reversal

        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = curr.next;
            curr.next = next;
            next = curr;
            curr = temp;
        }

        // 3. Reconnect
        prev.next = next;
        tail.next = curr;

        return dummy.next;
    }
}