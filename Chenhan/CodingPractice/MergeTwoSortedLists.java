public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            ListNode next = new ListNode(0);
            if (l1.val < l2.val) {
                next.val = l1.val;
                l1 = l1.next;
            } else {
                next.val = l2.val;
                l2 = l2.next;
            }
            node.next= next;
            node = node.next;
        }
        if (l1 == null && l2 == null) {
            return dummy.next;
        }
        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }
        return dummy.next;
    }
}