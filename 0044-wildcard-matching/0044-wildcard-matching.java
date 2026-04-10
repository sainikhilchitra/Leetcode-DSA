class Solution {

    int isWildcard(int dp[][], int i, int j,String s,String p){
        
        if(i <= 0 && j <= 0){
            dp[i][j] = 1 ;
        }
        if(j <= 0){
            dp[i][j] = 0 ;
        }

        if(i <= 0){
            for(int idx = 0 ; idx < j ; idx++){
                if(p.charAt(idx) != '*') {
                    dp[i][j] = 0 ;
                    return dp[i][j] ;
                }
            }
            dp[i][j] = 1 ;
        }


        if(dp[i][j] != -1) return dp[i][j] ;
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
            dp[i][j] = isWildcard(dp, i - 1, j - 1, s, p) ;
        }
        else if(p.charAt(j - 1) == '*'){
            dp[i][j] = (isWildcard(dp, i, j - 1, s, p) == 1 || isWildcard(dp,i - 1, j, s, p) == 1) ? 1 : 0;
        }
        else{
            dp[i][j] = 0 ;
        }

        return dp[i][j] ;
    }
    public boolean isMatch(String s, String p) {
        
        int n1 = s.length(), n2 = p.length() ;
        int dp[][] = new int[n1 + 1][n2 + 1] ;

        for(int i = 0 ; i <= n1 ; i++){
            Arrays.fill(dp[i], -1) ;
        }
        isWildcard(dp,n1,n2,s,p) ;
        return  dp[n1][n2] == 1 ;
    }
}