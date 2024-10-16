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
    class Pair{
        int num;
        TreeNode node;
    Pair(int num,TreeNode node){
        this.num=num;
        this.node=node;
    }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<Pair>();
         int width=0;
         q.add(new Pair(0,root));
         while(!q.isEmpty()){
            int size = q.size();
            int min=q.peek().num;
            int start =0;
            int last =0;
         for(int i=0; i<size; i++){
            int num = q.peek().num-min;
            TreeNode temp = q.peek().node;
            q.remove();
            if(i==0) start=num;
            if(i==size-1) last=num;
            if(temp.left!=null) q.add(new Pair(2*num+1,temp.left));
            if(temp.right!=null) q.add(new Pair(2*num+2,temp.right));
         }
           width = Math.max(width,last-start+1);
         }
         return width;
    }
}