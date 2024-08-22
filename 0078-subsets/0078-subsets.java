class Solution {
    public static void findSubsets(int idx,int[] nums, List<List<Integer>> ans, List<Integer> ds){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        findSubsets(idx+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        findSubsets(idx+1,nums,ans,ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
       findSubsets(0,nums,ans,new ArrayList<>());
       return ans;
    }
}