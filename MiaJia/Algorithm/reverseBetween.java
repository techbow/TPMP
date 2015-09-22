public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // 看到值域，先考虑合不合法 m >= n , 本题中已经check过。
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

Method 2
        public ListNode reverseBetween(ListNode head, int m , int n) {
        //construct dummy node
        if( head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        //find breakpoint1 and breakpoint2
        //note that i is easy to error
        for(int i = 1; i < m; i++){
            head = head.next;
        }
        ListNode end1 = head;
        ListNode head2 = head.next;
        for(int i = m-1; i < n; i++){
            head = head.next;
        }
        ListNode end2 = head;
        ListNode head3 = head.next;
        //reverse [m,n]
        end2.next = null;
        ListNode newh = reverse(head2);
        
        //link three list
        end1.next = newh;
        while(newh.next != null){
            newh = newh.next;
        }
        newh.next = head3;

        return dummy.next;
    }
    public ListNode reverse(ListNode head) {       
        ListNode pre = null;
        while( head != null){
            ListNode temp = head.next;
            head.next = pre;               
            pre = head;
            head = temp;
        }
        return pre;           
    }