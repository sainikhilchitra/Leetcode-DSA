class Solution {
    int count=0;
    boolean isSafe(boolean board[][] , int r,int c,int n){
        for(int i=0;i<n;i++){
            if(board[i][c]) return false;
        }
        for(int i=r,j=c ; i>=0 && j>=0 ;i--,j--){
            if(board[i][j]) return false ;
        }
        for(int i=r,j=c ; i>=0 && j<n ;i--,j++){
            if(board[i][j]) return false ;
        }
        return true ;
    }
    void nQueens(boolean board[][],int r,int n){
        if(r==n){
            count++;
            return ;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,r,i,n)){
                board[r][i] = true ;
                nQueens(board,r+1,n);
                board[r][i] = false ;
            }
        }
    }
    public int totalNQueens(int n) {
        boolean board[][] = new boolean[n][n] ;
        nQueens(board,0,n);
        return count ;
    }
}