/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==p || root==q ||root==null){
          return root;
       }
       TreeNode left = helper(root.left,p,q);
       TreeNode right = helper(root.right,p,q);
       if(left==null){
         return right;
       }else if(right==null){
        return left;
       }else{
          return root;
       }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return helper(root,p,q);
    }
}