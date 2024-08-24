class Solution {
    public static void findCombinations(int idx,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds,int sum){
        if(sum>target){
            return;
        }
        if(idx==arr.length){
          if(target==sum){
            ans.add(new ArrayList<>(ds));
          }
           return;
        }
          ds.add(arr[idx]);
          sum = sum+arr[idx];
          findCombinations(idx,arr,target,ans,ds,sum);
          ds.remove(ds.size()-1);
          sum = sum-arr[idx];
        findCombinations(idx+1,arr,target,ans,ds,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  ans = new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
}