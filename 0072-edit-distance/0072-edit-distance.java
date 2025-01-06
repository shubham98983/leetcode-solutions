class Solution {
    public static int f(int i, int j, String word1, String word2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(word1.charAt(i)==word2.charAt(j)){
            return 0+f(i-1,j-1,word1,word2);
        }
        return Math.min(1+f(i-1,j-1,word1,word2), Math.min(1+f(i,j-1,word1,word2),1+f(i-1,j,word1,word2)));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=m; i++){
            dp[0][i]=i;
        }
        for(int i=0; i<=n; i++){
            dp[i][0]=i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int insert = 1+dp[i][j-1];
                    int delete = 1+dp[i-1][j];
                    int replace = 1+dp[i-1][j-1];
                    dp[i][j] = Math.min(insert , Math.min(delete,replace));
                }
            }
        }
        return dp[n][m];
    }
}