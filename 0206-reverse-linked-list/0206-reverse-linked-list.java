
class Solution {
    public ListNode reverseList(ListNode head) {
        // ListNode prev = null;
        // ListNode curr = head;
        // ListNode agla = null;
        // while(curr!=null){
        //     agla = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = agla;
        // }
        // return prev;

        
          /* USING RECURSION */
   if(head == null || head.next == null ) return head;
    ListNode  newHead = reverseList(head.next);
     head.next.next = head;
     head.next = null;
     return newHead;

    }
}