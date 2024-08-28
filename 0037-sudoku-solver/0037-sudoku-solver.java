class Solution {
    public static boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                        if(solve(board)==true){
                            return true;
                        }
                        else{
                            board[i][j]='.'; //backtracking step to remove filled place
                        }
                    }
                }
                // ye recursive functions return krenge
                return false;
            }
        }
    }
    // if there is no empty space return true;
    return true;
    }
    public static boolean isValid(char[][] board,int row,int col,char c){
        for(int i=0; i<9; i++){
            //for row
            if(board[row][i]==c) return false;
            if(board[i][col]==c) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
