class Solution {
    public Node copyRandomList(Node head) 
    {
        // 7 13 11 10 1
        // n 7  1 11 7
        
        Node head2 = new Node(0);
        Node temp2 = head2;
        Node temp1 = head;

        // Creating deep Copy
        while(temp1 != null){
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = t;
            temp1 = temp1.next;
        }

        head2 = head2.next;  
        temp2 = head2;
        temp1 = head;

        // Alternate Connection
        Node temp = new Node(-1);

        while(temp1 != null){  
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }

        temp2 = head2;
        temp1 = head;

        // Random pointer Assign
        while(temp1 != null){   

            if(temp1.random == null && temp2.random == null)
                temp2.random = null;
            else
                temp2.random = temp1.random.next;   

            temp1 = temp2.next;

            if(temp1 != null)
                temp2 = temp1.next;
        }

        // Separating the head
        temp2 = head2;
        temp1 = head;

        while(temp1 != null ){
            temp1.next = temp2.next;
            temp1 = temp1.next;

            if(temp1 == null) break;

            temp2.next = temp1.next;

            if(temp2.next == null) break;

            temp2 = temp2.next;
        }

        return head2;
    }
}