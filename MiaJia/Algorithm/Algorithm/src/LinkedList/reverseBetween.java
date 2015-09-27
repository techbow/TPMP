package LinkedList;

public class reverseBetween {
	public ListNode reverseBetween(ListNode head, int m , int n) {
		if( head == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		for(int i = 0; i < m; i++){
			head = head.next;
		}
		ListNode end1 = head;
		ListNode head2 = head.next;
		for(int i = 0; i < n; i++){
			head = head.next;
		}
		ListNode end2 = head.next;
		ListNode head3 = end2.next;
		
		end2.next = null;
		ListNode newh = reverse(head2);
		end1.next = newh;
		while(newh != null){
			newh = newh.next;
		}
		newh.next = head3;

		return dummy.next;
	}
	public ListNode reverse(ListNode head) {       
		ListNode pre = null;
		while( head != null){
			ListNode temp = head.next;
			head.next = pre;               
			pre = head;
			head = temp;
		}
		return pre;           
	}
}
