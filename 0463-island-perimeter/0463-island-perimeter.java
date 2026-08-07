class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] != 1) continue ;
                if(j == 0 || grid[i][j - 1] != 1) count++ ;
                if(i == 0 || grid[i - 1][j] != 1) count++ ;
                if(j + 1 == grid[i].length || grid[i][j + 1] == 0) count++ ;
                if(i + 1 == grid.length || grid[i + 1][j] == 0) count++ ;
            }
        }
        return count ;
    }
}