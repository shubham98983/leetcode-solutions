class Solution {
    static class Trio{
        int row;
        int col;
        int dist;
    public Trio(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Trio> q = new LinkedList<>();
        int ans[][] = new int[n][m];
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
            Trio curr = q.poll();
            int row=curr.row;
            int col=curr.col;
            int dist = curr.dist;
            ans[row][col]=dist;
            for(int i=0; i<4; i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false){
                    vis[nrow][ncol]=true;
                    q.add(new Trio(nrow,ncol,dist+1));
                }
            }
        }
        return ans;
    }
}