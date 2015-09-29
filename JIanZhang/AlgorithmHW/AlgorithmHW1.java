// Remove Duplicates from Sorted List II

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
	        
	      ListNode previous = new ListNode(0);
	       previous.next = head;
	       head= previous;
	       
	       while(head.next !=null && head.next.next !=null){
	           if (head.next.val == head.next.next.val){
	               int val = head.next.val;
	               while (head.next !=null && head.next.val == val){
	                   head.next=head.next.next;
	               }
	           } else {
	               head = head.next;
	           }
	       }
	       return previous.next;
	        }
}
	 