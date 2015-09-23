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
        if(head == null || head.next == null) return head;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        
        ListNode slow = (head.val == head.next.val) ? dummyhead : head;
        ListNode fast = slow.next;
        int dul = head.val; //record last duplicated number
        while (fast.next != null){
            if ((fast.val != fast.next.val) && (fast.val != dul)){
                slow.next = fast;
                slow = slow.next;
            }
            else{
                dul = fast.val;
            }
            fast = fast.next;
        }
        slow.next = (fast.val == dul) ? fast.next : fast;
        return dummyhead.next; //the head of new list
    }
}



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