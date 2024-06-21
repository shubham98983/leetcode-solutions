class Solution {
    static class Trio{
        int ro;
        int co;
        int dist;
    public Trio(int ro,int co,int dist){
        this.ro=ro;
        this.co=co;
        this.dist=dist;
    }
    }
    public int[][] updateMatrix(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;
      boolean vis[][] = new boolean[n][m];
      int dis[][] = new int[n][m];
      Queue<Trio> q = new LinkedList<Trio>();
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(mat[i][j]==0){
              vis[i][j]=true;
              q.add(new Trio(i,j,0));
            }
        }
      }
      int delrow[] = {-1,0,1,0};
      int delcol[] = {0,1,0,-1};
      while(!q.isEmpty()){
        int row = q.peek().ro;
        int col = q.peek().co;
        int step = q.peek().dist;
        q.remove();
        dis[row][col]=step;
        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&vis[nrow][ncol]==false){
                 vis[nrow][ncol]=true;
                 q.add(new Trio(nrow,ncol,step+1));
        }
      }
    }
    return dis;
}
}