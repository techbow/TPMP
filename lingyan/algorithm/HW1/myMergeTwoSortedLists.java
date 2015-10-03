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
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = l1;
        l1 = dummyhead;
        
        while((l1.next != null) && (l2 != null)){
            if(l1.next.val > l2.val){
                ListNode temp = l2.next;
                l2.next = l1.next;
                l1.next = l2;
                l2 = temp;
            }
            l1 = l1.next;
        }
        if(l1.next == null){
            l1.next = l2;
        }
        
        return dummyhead.next;
    }
}