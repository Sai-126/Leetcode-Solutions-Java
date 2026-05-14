class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create copy of each node
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node copyNode = map.get(curr);

            copyNode.next = map.get(curr.next);
            copyNode.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}