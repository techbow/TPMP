////it is accepted by lintcode, here is submission copy from lintcode, cannot run this file.
//http://www.lintcode.com/en/problem/merge-two-sorted-lists/submissions/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        
        if (l1 == null && l2 == null){
            return null;
        }
        else if(l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                head.next = l1;
                head = l1;
                l1 = l1.next;
            }
            else {
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
        }//while
        
        if (l1 == null && l2 != null){
            head.next = l2;
        }
        else if(l2 == null && l1 != null){
            head.next = l1;
        }//if
        
        return dummyNode.next;
    }//publick ListNode ...
}
