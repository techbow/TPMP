public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // 一定先考虑异常检查
        //看到值域，先考虑合不合法
        if (m >= n || head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head.next == null){
                return null;
            } else {
                head = head.next;
            }
        }
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;
        
        for (int i = m; i < n; i++) {
            //若N超出链表的值
            if (postnNode == null) {
                return null;
            } else {
                ListNode temp = postnNode.next;
                postnNode.next = nNode;
                nNode = postnNode;
                postnNode = temp;
            }
        }
            
        premNode.next = nNode;
        mNode.next = postnNode;
            
        return dummy.next;
    }
}
