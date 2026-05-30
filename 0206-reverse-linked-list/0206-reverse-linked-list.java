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
        // ListNode cur = head,prev = null ;

        // while(cur != null){
        //     ListNode n = cur.next ;
        //     cur.next = prev ;
        //     prev = cur ;
        //     cur = n ;
        // }

        // return prev ;
    }
}