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
        int dp[][] = new int[c+1][c+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return f(1,c,cut,dp);
    }
}