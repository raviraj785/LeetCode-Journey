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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null ;
        ListNode curr = slow;
        ListNode agla ;

        while(curr != null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        } 
        int max = 0;
        ListNode left = head;
        ListNode right = prev;
        while(right != null){
        int sum = left.val + right.val;
         max = Math.max(sum , max);

        left = left.next;
        right = right.next;
        }
        
       return max;
    }
    
}