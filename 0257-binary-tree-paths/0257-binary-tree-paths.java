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
    public static void treePath(TreeNode root,String s,List<String> ans){
        if(root==null) return;
             if(!s.isEmpty()){
           s = s + "->" + root.val;
        }else{  
            s = s + root.val;
        }
        if(root.left==null && root.right==null){
            ans.add(new String(s));
            return;
        }
        treePath(root.left,s,ans);
        treePath(root.right,s,ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        treePath(root, "",ans);
        return ans;
    }
}