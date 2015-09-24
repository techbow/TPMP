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
        if ((m >= n) || (head == null)){
            return head;
        }
        
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        head = dummyhead;   
        
        for(int i = 1; i < m; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        } //head point to m-1 node;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = p2.next;

        //Question: why when create p3, you don`t need to varify if (p2.next == null)

        for (int i = m; i < n ; i++){
            if (p3 == null){
                return null;
            }
                p2.next = p3.next;
                p3.next = p1.next;
                p1.next = p3;
                p3 = p2.next;
        }

        return dummyhead.next;
    }
}