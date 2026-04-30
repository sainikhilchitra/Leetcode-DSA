class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length ;
        int m = dungeon[0].length ;

        int dp[][] = new int[n][m] ;

        dp[n - 1][m - 1] = Math.min(0,dungeon[n - 1][m - 1]) ;
        for(int i = n - 2 ; i >= 0 ; i--){
            dp[i][m - 1] = Math.min(0,dungeon[i][m - 1] + dp[i + 1][m - 1]) ;
        }

        for(int i = m - 2 ; i >= 0 ; i--){
            dp[n - 1][i] = Math.min(0,dungeon[n - 1][i] + dp[n - 1][i + 1]) ;
        }

        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = m - 2 ; j >= 0 ; j--){
                dp[i][j] = Math.min(0, Math.max(dp[i + 1][j],dp[i][j + 1]) + dungeon[i][j]) ;
            }
        }

        return Math.abs(dp[0][0]) + 1 ;
    }
}