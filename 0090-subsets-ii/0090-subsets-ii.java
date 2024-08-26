class Solution {
    public static void findCombinations(int idx,int[] nums,int n,List<List<Integer>> ans,List<Integer> ds){
         ans.add(new ArrayList<>(ds));
          for(int i=idx; i<n; i++){
          if(i!=idx && nums[i]==nums[i-1]) continue;
          ds.add(nums[i]);
          findCombinations(i+1,nums,n,ans,ds);
          ds.remove(ds.size()-1);
          }
        }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
     int n = nums.length;
     Arrays.sort(nums);
     findCombinations(0,nums,n,ans,new ArrayList<>());
     return ans;
    }
}