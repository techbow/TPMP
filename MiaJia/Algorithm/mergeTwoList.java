public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
     //注意题目要求，是将B数组merge到A中。由于不想使用额外的空间，采用从后往前merge的方法。在面试的时候需要同面试官确认数组的排序方式是ascending还是descending。


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        //why l1,l2 instand of l1.next;l2.next??
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        
        return dummy.next;
    }
}

