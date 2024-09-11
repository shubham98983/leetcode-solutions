class Solution {
    public static int gcd(int a,int b){
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
    public int findGCD(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int max=nums[0];
        int min=nums[0];
        for(int i=0; i<n; i++){
            if(nums[i]>max){
                max=nums[i];
            }else if(nums[i]<min){
                min=nums[i];
            }
        }
        return gcd(max,min);
    }
}