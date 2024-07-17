class Solution {
    public int[] twoSum(int[] nums, int target) {
     int sum=0;
     int n = nums.length;
     int first = 0;
     int last = 0;
     for(int i=0; i<n; i++){
         for(int j=i+1; j<n; j++){
             sum = nums[i] + nums[j];
             if(sum==target){
                 first = i;
                 last= j;
             }
         }   
    }
    int array[] = new int[2];
    array[0] = first;
    array[1] = last;
    return array;
}
}