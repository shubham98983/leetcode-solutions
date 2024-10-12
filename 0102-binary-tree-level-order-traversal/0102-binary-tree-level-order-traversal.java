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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        q.add(null);
        ans.add(new ArrayList<>());
        int i=0;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                ans.add(new ArrayList<>());
                i++;
                q.add(null);
                }
            }else{
                ans.get(i).add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}