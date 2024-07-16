class Solution {
    public int removeDuplicates(int[] nums) {
      LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
      for(int i=0; i<nums.length; i++){
          lhs.add(nums[i]);
      }
      int idx=0;
     // Iterator it =lhs.iterator();
     for(Integer it : lhs){
        nums[idx]=it;
        idx++;
     }
      return lhs.size();
    }
}