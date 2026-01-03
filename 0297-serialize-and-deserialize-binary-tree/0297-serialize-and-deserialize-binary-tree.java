/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    void serializeHelper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,") ;
            return ;
        }
        sb.append(root.val).append(",") ;
        serializeHelper(root.left,sb) ;
        serializeHelper(root.right,sb) ;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder() ;
        serializeHelper(root,sb) ;
        return sb.toString() ;
    }

    // Decodes your encoded data to tree.
    int idx = 0 ;
    TreeNode construct(String[] nodes){
        if(nodes[idx].equals("null")) {
            idx++ ;
            return null ;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx++])) ;
        root.left = construct(nodes);
        root.right = construct(nodes) ;
        return root ;
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return construct(nodes) ;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));