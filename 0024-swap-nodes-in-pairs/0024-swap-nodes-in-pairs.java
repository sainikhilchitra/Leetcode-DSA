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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null ;
        ListNode dummy = new ListNode(-1, head) ;
        ListNode prev = dummy ;
        while(head != null && head.next != null){
            ListNode temp = head.next.next ;
            prev.next = head.next ;
            head.next.next = head ;
            head.next = temp ;
            prev = head ;
            head = temp ;
        }
        return dummy.next ;
    }
}