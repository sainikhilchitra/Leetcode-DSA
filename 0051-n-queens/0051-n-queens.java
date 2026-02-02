class Solution {
    List<List<String>> sol = new ArrayList<>() ;
    boolean isSafe(boolean board[][] , int r,int c,int n){
        for(int i=0;i<n ;i++){
            if(board[r][i]) return false;
        }
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
            ArrayList<String> al = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder row = new StringBuilder() ;
                for(int j =0 ;j<n;j++){
                    if(board[i][j]){
                        row.append("Q");
                    }
                    else{
                        row.append(".");
                    }
                }
                al.add(row.toString());
            }
            sol.add(al) ;
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
    public List<List<String>> solveNQueens(int n) {
        boolean board[][] = new boolean[n][n] ;
        nQueens(board,0,n);
        return sol ;
    }
}