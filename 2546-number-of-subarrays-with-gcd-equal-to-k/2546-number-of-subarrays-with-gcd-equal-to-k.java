class Solution {
    public static int isGcd(int a,int b){
        while(a>0 && b>0){
        if(a>b){
            a=a%b;
        }else{
            b=b%a;
        }
        }
       if(a==0) return b;
       return a;
    }
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
         int count=0;
        for(int i=0; i<n; i++){
                int firstGcd=nums[i];
            for(int j=i; j<n; j++){
               int newGcd = isGcd(firstGcd,nums[j]);
               if(newGcd==k){
                   count++;
               }
               firstGcd=newGcd;
            }
        }
        return count;
    }
}