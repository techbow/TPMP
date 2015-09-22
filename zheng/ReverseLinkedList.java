/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) {
            return head;
        }
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode prev = helper;
        n = n - m;
        while(m > 1) {
            prev = prev.next;
            m--;
        }
        ListNode left = prev.next;
        ListNode right = left.next;
        while(n > 0) {
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
            n--;
        }
        prev.next.next = right;
        prev.next = left;
        return helper.next;
    }
}
