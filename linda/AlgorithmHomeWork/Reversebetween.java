////it is accepted by lintcode, here is submission copy from lintcode, cannot run this file.
//http://www.lintcode.com/en/problem/reverse-linked-list-ii/submissions/

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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode preFirst = null;
        ListNode temp = null; 
        ListNode pre = null;
        ListNode headStart = null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        for (int i = 1; i <= n + 1; i++){
            
            if (i < m + 1){
                preFirst = head;
                head = head.next; 
            }
            if (i == m + 1){
                headStart = head;
                pre = head;
                head = head.next;
            }
            else if (i > m + 1 && i < n + 1){
                temp = head.next;
                head.next = pre;
                pre = head;
                head = temp; 
            }
            else if (i == n + 1){
                preFirst.next = head;
                headStart.next = head.next;
                head.next = pre;
                
            }
        }
        return dummyNode.next;
    }
}
