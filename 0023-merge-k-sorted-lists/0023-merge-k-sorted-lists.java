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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1) ;
        ListNode cur = dummy ;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val) ;
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null){
                pq.offer(lists[i]) ;
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll() ;
            if(node.next != null){
                pq.offer(node.next) ;
            }
            cur.next = node ;
            cur = cur.next ;
            cur.next = null ;
        }
        return dummy.next ;
    }
}