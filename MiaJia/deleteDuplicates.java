//Remove Duplicates from Sorted List II
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
        if( head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //head已经check过，不需要在check；此时只需要保证接下来要比较的元素不
        //为null；
        //本题中， head.next & head.next.next;
        while ( head.next != null && head.next.next != null){
            //if用来记住duplicate的值，while循环用来更新head.next的值
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                while( head.next != null && head.next.val == val){
                    head.next = head.next.next;
                }
            }
            else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}