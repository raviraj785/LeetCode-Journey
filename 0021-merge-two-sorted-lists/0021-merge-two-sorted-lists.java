/* 1st apporach whith O(n) TC */

/*  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head = new ListNode(100);
        ListNode temp = head;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                ListNode a = new ListNode(temp1.val);
                temp.next = a;
                temp = a;
                temp1 = temp1.next;
            } else {
                ListNode a = new ListNode(temp2.val);
                temp.next = a;
                temp = a;
                temp2 = temp2.next;
            }
        }

        if (temp1 == null) {
            temp.next = temp2;
        } else {
            temp.next = temp1;
        }

        return head.next;
    }
}
*/
// with O(1) 
class Solution{
    public static ListNode mergeTwoLists(ListNode list1 , ListNode list2){
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode h = new ListNode(100);
        ListNode t = h;
        while(t1 != null && t2 !=null ){
            if(t1.val < t2.val){
                t.next = t1;
                t = t1;
                t1 = t1.next;

            }
            else{
                t.next = t2;
                t = t2;
                t2 = t2.next;
            }
        }
        if(t1==null){ //t1 is Null
            t.next = t2 ;
        }
        else{ // t2 is Null
            t.next = t1;
        }
        return h.next;
    }
}