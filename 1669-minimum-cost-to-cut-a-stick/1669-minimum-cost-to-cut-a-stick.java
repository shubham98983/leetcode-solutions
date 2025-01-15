class Solution {
    public int f(int i, int j, ArrayList<Integer> cuts,int[][] dp){
        if(i>j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind =i; ind<=j; ind++){
           int ans = cuts.get(j+1)-cuts.get(i-1)+f(i,ind-1,cuts,dp)+f(ind+1,j,cuts,dp);
           mini = Math.min(ans,mini);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        ArrayList<Integer> cut = new ArrayList<>();
        cut.add(0);
        cut.add(n);
        for(int i=0; i<c; i++){
           cut.add(cuts[i]);
        }
        Collections.sort(cut);
        int dp[][] = new int[c+2][c+2];
        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){
                if(i>j) continue;
                int mini=Integer.MAX_VALUE;
            for(int ind=i; ind<=j; ind++){
                int cost = cut.get(j+1) - cut.get(i-1) +dp[i][ind-1]+dp[ind+1][j];
                mini = Math.min(mini,cost);
            }
              dp[i][j]=mini;
            }
        }
        return dp[1][c];
    }
}