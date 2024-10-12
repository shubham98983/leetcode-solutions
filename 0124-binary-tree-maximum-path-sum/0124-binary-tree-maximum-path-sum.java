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
    public static int pathSum(TreeNode root,int[] arr){
      if(root==null) return 0;
      int ls = Math.max(0,pathSum(root.left,arr));
      int rs = Math.max(0,pathSum(root.right,arr));
      arr[0] = Math.max(arr[0],(ls+rs+root.val));
      return root.val+Math.max(ls,rs);
    }
    public int maxPathSum(TreeNode root) {
        int[] arr = {Integer.MIN_VALUE};
        pathSum(root,arr);
        return arr[0];
    }
}