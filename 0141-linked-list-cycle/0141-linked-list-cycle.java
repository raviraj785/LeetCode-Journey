

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null){
            return false;
        }
        if(head.next == null){
            return false;
        }
        while(fast!=null){
            if(slow == null) return false;
            slow =  slow.next;
            if(fast.next == null) return false;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}