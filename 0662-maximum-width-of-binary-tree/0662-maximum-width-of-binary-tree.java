/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    TreeNode node ;
    int pos ;
    Pair(TreeNode node,int pos){
        this.node = node ;
        this.pos = pos ;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0 ;
        Queue<Pair> q = new LinkedList<>() ;
        q.offer(new Pair(root,0));
        int ans = 0 ;
        while(!q.isEmpty()){
            int n = q.size() ;
            int first = q.peek().pos ;
            int last = first ;
            for(int i=0;i<n;i++){
                Pair p = q.poll() ;
                last = p.pos ;
                if(p.node.left != null){
                    q.offer(new Pair(p.node.left,2*p.pos+1)) ;
                }
                if(p.node.right != null){
                    q.offer(new Pair(p.node.right,2*p.pos+2)) ;
                }
            }
            ans = Math.max(ans,last-first+1) ;
        }
        return ans ;
    }
}