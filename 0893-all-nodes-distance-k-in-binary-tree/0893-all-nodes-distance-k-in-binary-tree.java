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
    public static void findParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp.left!=null){
                parent.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                parent.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        findParent(root,parent);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size = q.size();   //to traverse all bfs nodes of nodes in queue
            if(curr_level==k) break;
            curr_level++;
            for(int i=0; i<size; i++){
                TreeNode curr = q.remove();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    q.add(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }
        // at k==2 mein jo nodes remaining h queue m vo at k distance
        List<Integer> ans  = new ArrayList<>(); 
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            ans.add(temp.val);
        }
        return ans;
    }
}