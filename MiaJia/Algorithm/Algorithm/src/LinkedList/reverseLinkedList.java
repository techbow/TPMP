package LinkedList;
import java.util.LinkedList;

import LinkedList.ListNode;


public class reverseLinkedList {
	 public static ListNode reverse(ListNode head) {
	        if( head == null || head.next == null){
	            return head;}
	            
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        LinkedList<ListNode> newList = new LinkedList<ListNode>();
	        
	        while(dummy.next != null){
	        	newList.addFirst(dummy.next);
	            dummy.next = dummy.next.next;	            
	        }
	        return  newList.getFirst();
	    }
	 public static void main(String[] args) {

		   // create a LinkedList
		   LinkedList<ListNode> list = new LinkedList<ListNode>();
		   ListNode L0 = new ListNode(0);
		   ListNode L1 = new ListNode(1);

		   // add some elements
		   list.add(L0);
		   list.add(L1);
		   
		   System.out.println(reverse(L0).val);
		   System.out.println(reverse(L0).next.val);
	 }
}
