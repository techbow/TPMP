public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode left = helper;
		ListNode right = head;
		while(right != null) {
			while (right.next != null && left.next.val == right.next.val) {
				right = right.next;
			}
			if(left.next == right) {
				left = right;
			} else {
				left.next = right.next;
			}
			right = right.next;
		}
		return helper.next;
	}
}
