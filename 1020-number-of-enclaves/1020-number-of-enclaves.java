class Solution {
    void dfs(int[][] grid,int row,int col,int n,int m){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] != 1) return ;

        grid[row][col] = 2 ;

        dfs(grid,row - 1,col,n,m) ; 
        dfs(grid,row,col + 1,n,m) ; 
        dfs(grid,row + 1,col,n,m) ; 
        dfs(grid,row,col - 1,n,m) ; 
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;

        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 1) dfs(grid,i,0,n,m) ;
            if(grid[i][m - 1] == 1) dfs(grid,i,m - 1,n,m) ;
        }

        for(int j = 0 ; j < m ; j++){
            if(grid[0][j] == 1) dfs(grid,0,j,n,m) ;
            if(grid[n - 1][j] == 1) dfs(grid,n-1,j,n,m) ;
        }

        int ans = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1) ans++ ;
            }
        }

        return ans ;
    }
}