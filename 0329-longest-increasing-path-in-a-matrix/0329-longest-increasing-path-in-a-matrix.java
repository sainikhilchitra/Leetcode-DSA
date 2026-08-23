class Solution {
    int dx[] = {-1,0,1,0} ;
    int dy[] = {0,1,0,-1} ;
    int dfs(int matrix[][],int i,int j,int prev,int n,int m,int dp[][]){
        if(i < 0 || j < 0 || i >= n || j >= m || prev >= matrix[i][j]) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ;
        int ans = 0 ;
        for(int move = 0 ; move < 4 ; move++){
            ans = Math.max(ans,1 + dfs(matrix,i + dx[move],j + dy[move],matrix[i][j],n,m,dp)) ;
        }
        return dp[i][j] = ans ;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length ;
        int dp[][] = new int[n][m] ;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1) ;
        }
        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(dp[i][j] == -1){
                    dfs(matrix,i,j,-1,n,m,dp) ;
                }
                ans = Math.max(ans,dp[i][j]) ;
            }
        }
        return ans ;
    }
}