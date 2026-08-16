class Solution {
    public Node flatten(Node head) {
        Node temp = head;

        while (temp != null) {

            if (temp.child != null) {

                Node t = temp.next;

                Node C = flatten(temp.child);

                temp.next = C;
                C.prev = temp;

                while (C.next != null) {
                    C = C.next;
                }

                C.next = t;

                if (t != null) {
                    t.prev = C;
                }

                temp.child = null;
            }

            temp = temp.next;
        }

        return head;
    }
}