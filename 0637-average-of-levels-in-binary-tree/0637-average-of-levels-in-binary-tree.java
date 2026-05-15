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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> avg = new ArrayList<>() ;
        Queue<TreeNode> q = new LinkedList<>() ;

        q.offer(root) ;

        while(!q.isEmpty()){
            int n = q.size() ;
            double sum = 0 ;

            for(int i = 0 ; i < n ; i++){
                TreeNode node = q.poll() ;

                if(node.left != null){
                    q.offer(node.left) ;
                }
                if(node.right != null){
                    q.offer(node.right) ;
                }

                sum += node.val ;
            }

            avg.add(sum / n) ;
        }

        return avg ;
    }
}