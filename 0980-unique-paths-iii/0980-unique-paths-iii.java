class Solution {
    int ans = 0 ;
    void traverse(int grid[][],boolean[][] visited,int row,int col,int n,int m,int edges,int curEdge){
        if(grid[row][col] == 2){
            if(curEdge == edges + 1){
                ans++ ;
            }
            return ;
        }
        if(visited[row][col] == true) return ;

        visited[row][col] = true ;
        if(row != 0 && grid[row - 1][col] != -1){
            traverse(grid,visited,row-1,col,n,m,edges,curEdge+1) ;
        }

        if(row != n-1 && grid[row+1][col] != -1){
            traverse(grid,visited,row+1,col,n,m,edges,curEdge+1) ;
        }

        if(col != 0 && grid[row][col-1] != -1){
            traverse(grid,visited,row,col-1,n,m,edges,curEdge+1) ;
        }

        if(col != m-1 && grid[row][col+1] != -1){
            traverse(grid,visited,row,col+1,n,m,edges,curEdge+1) ;
        }
        visited[row][col] = false ;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;

        int startRow = -1 ;
        int startCol = -1 ;
        int edges = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    startRow = i ;
                    startCol = j ;
                }
                if(grid[i][j] == 0) edges++ ;
            }
        }
        traverse(grid,new boolean[n][m],startRow,startCol,n,m,edges,0) ;

        return ans ;
    }
}