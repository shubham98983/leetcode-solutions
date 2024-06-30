class Solution {
    public static void dfs(int[][] ans,int[][] image,int row,int col,int initcolour,int color,int n,int m){
       int delrow[] = {-1,0,1,0};
       int delcol[] = {0,1,0,-1};
            ans[row][col]=color;
       for(int i=0; i<4; i++){
        int nrow = row+delrow[i];
        int ncol = col+delcol[i];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=color &&image[nrow][ncol]==initcolour ){
            dfs(ans,image,nrow,ncol,initcolour,color,n,m);
        }
       }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][] = image;
        int n = image.length;
        int m = image[0].length;
        int initcolour = image[sr][sc];
        dfs(ans,image,sr,sc,initcolour,color,n,m);
        return ans;
    }
}