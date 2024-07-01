class Solution {
    static class Trio{
        int row;
        int col;
        int step;
    public Trio(int row,int col,int step){
        this.row=row;
        this.col=col;
        this.step=step;
    }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Trio> q = new LinkedList<>();
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
            dist[i][j]=(int)(1e9);
        }
        }
        dist[0][0]=1;
       if(grid[0][0]==0 && n==1){
          return 1;
       } else if(grid[0][0]==1){
        return -1;
       }
        q.add(new Trio(0,0,1));
        int delrow[] = {-1,-1,0,1,1,1,0,-1};
        int delcol[] = {0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty()){
          int ro = q.peek().row;
          int co = q.peek().col;
          int steps = q.peek().step;
          q.remove();
          for(int i=0; i<8; i++){
            int nrow = ro+delrow[i];
            int ncol = co+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && steps+1 < dist[nrow][ncol]){
                dist[nrow][ncol]=steps+1;
                if(nrow==n-1 && ncol==n-1) return steps+1;
                q.add(new Trio(nrow,ncol,steps+1));
            }
          }
        }
        return -1;
    }
}