class Solution {
    public static boolean powerOfThree(int n,long ans){
        if(ans>n) return false;
        if(n==ans) return true;
        return powerOfThree(n,ans*3);
    }
    public boolean isPowerOfThree(int n) {
        if(n<0) return false;
        if(n==1) return true;
         long ans=1;
        return powerOfThree(n,ans);
    }
}