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
    public static void Sum(TreeNode root,int targetSum,List<List<Integer>> ans,List<Integer> ds){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(root.val==targetSum){
                ds.add(root.val);
                ans.add(new ArrayList<>(ds));
                ds.remove(ds.size()-1);
            }
            return;
        }
        targetSum-=root.val;
        ds.add(root.val);
        Sum(root.left,targetSum,ans,ds);
        Sum(root.right,targetSum,ans,ds);
        ds.remove(ds.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Sum(root,targetSum,ans,ds);
        return ans;
    }
}