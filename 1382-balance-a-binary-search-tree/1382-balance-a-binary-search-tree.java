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
    void inOrder(TreeNode root,ArrayList<Integer> nodes){
        if(root == null) return ;
        inOrder(root.left,nodes) ;
        nodes.add(root.val) ;
        inOrder(root.right,nodes) ;
    }

    TreeNode construct(ArrayList<Integer> nodes,int l,int r){
        if(l > r) return null ;

        int mid = (l + r) / 2 ;

        TreeNode root = new TreeNode(nodes.get(mid)) ;
        root.left = construct(nodes,l,mid - 1) ;
        root.right = construct(nodes,mid + 1,r) ;

        return root ;
    }
    public TreeNode balanceBST(TreeNode root) {
        
        ArrayList<Integer> nodes = new ArrayList<>() ;
        inOrder(root,nodes) ;
        return construct(nodes,0,nodes.size() - 1) ;

    }
}