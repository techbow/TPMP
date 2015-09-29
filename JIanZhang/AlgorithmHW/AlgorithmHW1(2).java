public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode previous = new ListNode(0);
        previous.next = head;
        head = previous;
        ListNode n1 =head;
        int k = m-1;
        while(k>0){
            n1 = n1.next;
            k--;
        }
        previous = n1;
        n1=n1.next;
        k=n-m;
        while(n1.next !=null && k>0){
            ListNode current = n1.next;
            n1.next = current.next;
            current.next = previous.next;
            previous.next = current;
            k--;
        }
        return head.next;
    }
}