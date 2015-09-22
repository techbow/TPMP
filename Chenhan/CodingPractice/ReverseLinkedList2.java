public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        ListNode prev = head;
        if (head.next == null || head.next.next == null) {
            return null;
        }
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode post = nNode.next;
        for (int i = m; i< n; i++) {
            if (post == null) {
                return null;
            }
            ListNode tmp = post.next;
            post.next = nNode;
            nNode = post;
            post = tmp;
        }
        prev.next = nNode;
        mNode.next = post;
        return dummy.next;
    }
}