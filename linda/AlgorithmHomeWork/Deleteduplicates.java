//it is accepted by lintcode, here is submission copy from lintcode, cannot run this file.
//http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/submissions/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null){
            return head;
        } 
        
        //create dummy head, in case remove the head as well
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        
        head = dummyhead;
        //search
        while (head.next != null && head.next.next != null ){
            if (head.next.val == head.next.next.val){
                int curVal = head.next.val;
                head.next = head.next.next.next;
                while (head.next != null && curVal == head.next.val){
                    head.next = head.next.next;
                }
            }
            else {
                head = head.next;
            }
        }
        return dummyhead.next;
    }
}

