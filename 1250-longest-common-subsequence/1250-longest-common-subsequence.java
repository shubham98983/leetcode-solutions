class Solution {
    public static int lcs(String s1, String s2, int ind1, int ind2, int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)) return 1+lcs(s1,s2,ind1-1,ind2-1,dp);
        return Math.max(lcs(s1,s2,ind1-1,ind2,dp),lcs(s1,s2,ind1,ind2-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int prev[] = new int[m+1];
        for (int i = 0; i <= m; i++) {
            prev[i] = 0;
        }
        for(int i=1; i<=n; i++){
            int[] curr = new int[m+1];
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) curr[j]=1+prev[j-1];
                else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
        }
        return prev[m];
    }
}