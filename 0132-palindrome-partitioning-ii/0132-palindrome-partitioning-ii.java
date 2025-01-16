class Solution {
    boolean isPallindrome(int i, int ind , String s){
        while(i<ind){
        if(s.charAt(i)!=s.charAt(ind)) return false;
        i++;
        ind--;
        }
        return true;
    }
    public int f(int i, int n , String s,int[] dp){
        if(i==n) return 0;
        int minCut = Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int ind=i; ind<n; ind++){
            if(isPallindrome(i,ind,s)){
                int cut = 1+f(ind+1,n,s,dp);
                minCut = Math.min(cut,minCut);
            }
        }
        return dp[i] = minCut;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(0,n,s,dp)-1;
    }
}