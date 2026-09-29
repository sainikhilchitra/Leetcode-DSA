class Solution {
    boolean dfs(char grid[][],int i,int j,int n,int m,int openCount,Boolean dp[][][]){
        if(i < 0 || j < 0 || i >= n || j >= m) return false ;
        if(grid[i][j] == ')' && openCount == 0) return false ;
        if(grid[i][j] == ')') openCount-- ;
        if(grid[i][j] == '(') openCount++ ;
        if(dp[i][j][openCount] != null) return dp[i][j][openCount] ;
        if(i == n - 1 && j == m - 1 && openCount == 0) return true ;
        boolean ans = dfs(grid,i + 1,j,n,m,openCount,dp) || dfs(grid,i,j + 1,n,m,openCount,dp) ;
        return dp[i][j][openCount] = ans ;
    }
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')' || grid[grid.length - 1][grid[0].length - 1] == '(') return false ;
        Boolean dp[][][] = new Boolean[grid.length][grid[0].length][grid.length + grid[0].length] ;
        return dfs(grid,0,0,grid.length,grid[0].length,0,dp) ;
    }
}