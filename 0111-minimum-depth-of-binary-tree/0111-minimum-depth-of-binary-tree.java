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
    public static int depth(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        if(root.left==null){
            return depth(root.right)+1;
        }
            if(root.right == null) {
            return depth(root.left) + 1;
        }
        int ls = depth(root.left);
        int rs = depth(root.right);
         return Math.min(ls,rs) +1;
    }
    public int minDepth(TreeNode root) {
        return depth(root);
    }
}