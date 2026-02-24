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
    int ans = 0 ;
    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null) return true ;
        return false ;
    }

    void traversal(TreeNode root, int num){
        if(root == null) return ;
        num = ((num << 1) | root.val) ;
        if(isLeaf(root)){
            ans += num ;
            return ;
        }

        traversal(root.left,num) ;
        traversal(root.right,num) ;
    }
    public int sumRootToLeaf(TreeNode root) {
        traversal(root,0) ;
        return ans ;
    }
}