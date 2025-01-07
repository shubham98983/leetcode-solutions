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
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = f(s.length()-1,p.length()-1,s,p,dp);
        return ans==0 ? false :true;
    }
}