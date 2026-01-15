class Solution {
    void dfs(char board[][],int row,int col,int n,int m){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O') return ;
        board[row][col] = 'S' ;

        dfs(board,row - 1,col,n,m) ;
        dfs(board,row,col + 1,n,m) ;
        dfs(board,row + 1,col,n,m) ;
        dfs(board,row,col - 1,n,m) ;
    }
    public void solve(char[][] board) {
        int n = board.length ;
        int m = board[0].length ;
        if(n == 1 || m == 1) return ;
        
        for(int i = 0 ; i < n ; i++){
            if(board[i][0] == 'O') dfs(board,i,0,n,m) ;
            if(board[i][m - 1] == 'O') dfs(board,i,m - 1,n,m) ;
        }

        for(int j = 0 ; j < m ; j++){
            if(board[0][j] == 'O') dfs(board,0,j,n,m) ;
            if(board[n - 1][j] == 'O') dfs(board,n - 1,j,n,m) ;
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'S') board[i][j] = 'O' ;
                else board[i][j] = 'X' ;
            }
        }
    }
}