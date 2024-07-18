class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum =0;
        int sumCount =0;
        hm.put(sum,1);
        for(int i=0; i<n; i++){
          sum = sum+nums[i];
          if(hm.containsKey(sum-k)){
              sumCount = sumCount+hm.get(sum-k);
          }
          if(!hm.containsKey(sum)){
            hm.put(sum,1);
          } else{
              hm.put(sum,hm.get(sum)+1);
          }
        } 
        return sumCount;
    }
}