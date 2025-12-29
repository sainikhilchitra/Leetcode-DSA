class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        long dp[][] = new long[2][target+1] ;
        long mod = (long) 1e9 + 7 ;
        dp[0][0] = 1 ;

        // instead of looping k times, maintain a prefix sum(sliding window)

        // currect sum + prevs sum of j-1 to j-k
        
        for(int i = 1 ; i <= n ; i++){
            dp[i % 2][0] = 0 ;
            for(int j = 1 ; j <= target ; j++){
                dp[i % 2][j] = dp[i % 2][j - 1] + dp[(i - 1) % 2][j-1] ;
                if(k < j){
                    dp[i % 2][j] = (dp[i % 2][j] - dp[(i - 1) % 2][j-k-1] + mod) % mod ;
                }
            }
        }
        return (int)dp[n % 2][target] ;
    }
}