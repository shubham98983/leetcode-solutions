class Solution {
    public int f(int i, int j , String s, String p,int[][] dp){
      if(i<0 && j<0) return 1;
      if(i>=0 && j<0) return 0;
      if(i<0 && j>=0){
        for(int k=0; k<=j; k++){
           if(p.charAt(k)!='*') return 0;
        }
        return 1;
      }
      if(dp[i][j]!=-1) return dp[i][j];
      if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
        return dp[i][j] = f(i-1,j-1,s,p,dp);
      }
      if(p.charAt(j)=='*'){
        return dp[i][j] = (f(i-1,j,s,p,dp)==1) || (f(i,j-1,s,p,dp)==1) ? 1 :0;
      }
      return dp[i][j]= 0;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n+1][m+1];
           dp[0][0]=1;
        for(int i=1; i<=n; i++){
            dp[i][0]=0;
        }
        int count=0;
        while(count<p.length()){
            if(p.charAt(count)=='*'){
                count++;
            }else break;
        }
        for(int i=1; i<=count; i++){
            dp[0][i]=1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j] = (dp[i-1][j]==1) || (dp[i][j-1]==1) ? 1: 0;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n][m]==1 ? true : false;
    }
}