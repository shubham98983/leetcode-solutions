class Solution {
  public static void dfs(char[][] board,boolean[][] vis,int row,int col,int n,int m){
  vis[row][col]=true;
  int delrow[] ={-1,0,1,0};
  int delcol[] ={0,1,0,-1};
  for(int k=0; k<4; k++){
  int nrow = row + delrow[k];
  int ncol = col + delcol[k];
  if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]==false){
     dfs(board,vis,nrow,ncol,n,m);
     }
     }
     }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int j=0; j<m; j++){
        //1st row
        if(board[0][j]=='O' && vis[0][j]==false){
         dfs(board,vis,0,j,n,m);
         }
        if(board[n-1][j]=='O' && vis[n-1][j]==false){
         dfs(board,vis,n-1,j,n,m);
         }
        }
        for(int i=0; i<n; i++){
        if(board[i][0]=='O' && vis[i][0]==false){
         dfs(board,vis,i,0,n,m);
         }
         if(board[i][m-1]=='O' && vis[i][m-1]==false){
         dfs(board,vis,i,m-1,n,m);
         }
         }
         for(int i=0; i<n; i++){
         for(int j=0; j<m; j++){
         if(board[i][j]=='O' && vis[i][j]==false){
         board[i][j]='X';
         }
         }
         }
    }
}