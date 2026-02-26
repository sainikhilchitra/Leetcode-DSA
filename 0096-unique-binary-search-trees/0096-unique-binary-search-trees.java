class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n + 1] ;
        dp[0] = 1 ;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                int left = j - 1 ;
                int right = i - j ;
                dp[i] = dp[i] + (dp[left] * dp[right]) ;
            }
        }

        return dp[n] ;
    }
}