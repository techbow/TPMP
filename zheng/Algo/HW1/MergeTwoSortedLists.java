/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        ListNode helper = new ListNode(0);
        helper.next = l1;
        ListNode curt = helper;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                l1 = l1.next;
            } else {
                ListNode l2Next = l2.next;
                l2.next = l1;
                curt.next = l2;
                l2 = l2Next;
            }
            curt = curt.next;
        }
        if(l1 != null) {
            return helper.next;
        }
        if(l2 != null) {
            curt.next = l2;
        }
        return helper.next;
    }
}
