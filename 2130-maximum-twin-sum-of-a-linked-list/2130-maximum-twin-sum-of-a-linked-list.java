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
    public int pairSum(ListNode head) {
        Deque<Integer> q = new LinkedList<>() ;
        while(head != null){
            q.offer(head.val) ;
            head = head.next ;
        }

        int ans = 0 ;
        while(!q.isEmpty()){
            ans = Math.max(ans,q.pollFirst() + q.pollLast()) ;
        }
        return ans ;
    }
}