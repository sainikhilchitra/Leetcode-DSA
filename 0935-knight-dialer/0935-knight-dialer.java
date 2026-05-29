class Solution {
    int knight(int i,int j,int n,Integer dp[][][]){
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j == 0) || (i == 3 && j == 2)) return 0 ;
        if(n == 0) return 1 ;

        if(dp[i][j][n] != null) return dp[i][j][n] ;

        int dx[] = {-2,-1,1,2,2,1,-1,-2} ;
        int dy[] = {1,2,2,1,-1,-2,-2,-1} ;

        dp[i][j][n] = 0 ;
        for(int move = 0 ; move < 8 ; move++){
            dp[i][j][n] = (dp[i][j][n] + knight(i + dx[move],j + dy[move],n - 1,dp)) % ((int) 1e9 + 7) ;
        }
        return dp[i][j][n] ;
    }
    public int knightDialer(int n) {
        
        Integer dp[][][] = new Integer[4][3][n + 1] ;
        int c = 0 ;
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                c = ( c + knight(i,j,n - 1,dp)) % ((int)1e9 + 7) ;
            }
        }

        return c ;
    }
}