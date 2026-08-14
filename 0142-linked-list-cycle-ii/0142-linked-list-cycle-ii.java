/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next==null){
            return null;
        }
        while(fast != null && fast.next != null){
            if(slow.next==null){
                return slow;
            }
            slow = slow.next;
            
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        ListNode temp = head;
        while(slow != temp){
            slow = slow.next;
            temp = temp.next;
        }
        return slow;
    }
}