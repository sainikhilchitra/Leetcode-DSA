class Solution {
    void dfs(char[][] grid,int row,int col,int n,int m){
        if(row < 0 || col < 0 || row == n || col == m || grid[row][col] != '1') return ;
        grid[row][col] = '2' ;
        dfs(grid,row - 1,col,n,m) ;
        dfs(grid,row,col + 1,n,m) ;
        dfs(grid,row + 1,col,n,m) ;
        dfs(grid,row,col - 1,n,m) ;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;

        int isLands = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    isLands++ ;
                    dfs(grid,i,j,n,m) ;
                }
            }
        }
        return isLands ;
    }
}