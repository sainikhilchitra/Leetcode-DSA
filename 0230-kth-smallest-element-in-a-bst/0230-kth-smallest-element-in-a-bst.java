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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0 ;
        Stack<TreeNode> stk = new Stack<>() ;
        int cnt = 0;
        while(true){
            if(root != null){
                stk.push(root) ;
                root = root.left ;
            }
            else{
                root = stk.pop() ;
                cnt++ ;
                if(cnt == k) break ;
                root = root.right ;
            }
        }
        return root.val ;
    }
}