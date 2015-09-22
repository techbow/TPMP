/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode current = prev;
        
        while(current.next != null && current.next.next != null)
        {
            if(current.next.val == current.next.next.val)
            {
                int duplicate = current.next.val;
                while(current.next != null && current.next.val == duplicate)
                {
                    current.next = current.next.next;
                }
            }
            else
            {
            current=current.next;
            }
        }
        return prev.next;
    }
}