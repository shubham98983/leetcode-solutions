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
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public int maxLength(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
        int product=nums[i];
        int prevGcd=nums[i];
        int prevLcm=nums[i];
        for(int j=i+1; j<n; j++){
            product=product*nums[j];
            prevGcd=gcd(prevGcd,nums[j]);
            prevLcm=lcm(prevLcm,nums[j]);
        if(product==prevGcd*prevLcm){
           int newans=j-i+1;
            ans=Math.max(ans,newans);
        }
        }
    }
    return ans;
}
}