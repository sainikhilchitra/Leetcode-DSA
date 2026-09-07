class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length() ;
        long mod = (long) 1e9 + 7 ;
        long res = 0 ;
        long dp[] = new long[n] ;
        Arrays.fill(dp,1) ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(s.charAt(i) == s.charAt(j)) continue ;
                dp[i] = (dp[i] + dp[j]) % mod ;
            }
            res = (res + dp[i]) % mod ;
        }
        return (int) res ;
    }
}