class Solution {
    public int f(int i, int j, ArrayList<Integer> list,int[][] dp){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i; ind<=j; ind++){
           int coin = (list.get(i-1)*list.get(ind)*list.get(j+1))+f(i,ind-1,list,dp)+
                       f(ind+1,j,list,dp);
            maxi = Math.max(maxi,coin);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        list.add(1);
        int dp[][] = new int[n+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return f(1,list.size()-2,list,dp);
    }
}