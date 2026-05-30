/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverse(ListNode n){
        if(n.next == null) return n ;
        ListNode head = reverse(n.next) ;
        n.next.next = n ;
        n.next = null ;
        return head ;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head ;

        return reverse(head) ;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        Stack<ListNode> stk = new Stack<>() ;

        ListNode cur = head,prev_cur = null,prev = head ;
        
        int n = 0 ;

        while(cur != null){
            n++ ;
            prev_cur = cur ;
            cur = cur.next ;
            if(n % k == 0){
                prev_cur.next = null ;
                stk.push(reverseList(prev)) ;
                prev = cur ;
            }
        }
        stk.push(prev) ;
        head = stk.get(0) ;

        cur = new ListNode(-1) ;
        for(ListNode node : stk){
            cur.next = node ;
            while(cur.next != null){
                cur = cur.next ;
            }
        }

        return head ;

    }
}