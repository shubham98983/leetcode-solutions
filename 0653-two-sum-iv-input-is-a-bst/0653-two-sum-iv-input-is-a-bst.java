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
    public static void preorder(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
    public boolean findTarget(TreeNode root, int k) {
       List<Integer> ans = new ArrayList<>();
       preorder(root,ans);
       boolean result=false;
       for(int i=0; i<ans.size(); i++){
          for(int j=i+1; j<ans.size(); j++){
               if(ans.get(j)==k-ans.get(i)){
                result=true;
               }
          }
       }
       return result;
    }
}