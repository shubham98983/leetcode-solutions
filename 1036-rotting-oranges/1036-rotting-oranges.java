class Solution {
    class Pair{
        int row;
        int col;
        int min;
    public Pair(int row,int col,int min){
        this.row=row;
        this.col=col;
        this.min=min;
    }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};
            int minute =0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
             minute = curr.min;
            for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==false){
                grid[nrow][ncol]=2;
                vis[nrow][ncol]=true;
                q.add(new Pair(nrow,ncol,minute+1));
            }
          }
        }
               for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    minute = -1;
                } 
            }
        }
        return minute;
    }
}