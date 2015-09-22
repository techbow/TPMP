public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode previous = current;
        
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                previous.next = l2;
                l2 = l2.next;
            }
            else { 
                previous.next = l1;
                l1 = l1.next;
        }
        previous = previous.next;
        }
        if(l1 != null) previous.next = l1;
        else if (l2 != null) previous.next = l2;
         return current.next;
    }

}