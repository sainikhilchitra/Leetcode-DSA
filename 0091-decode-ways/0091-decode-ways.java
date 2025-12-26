class Solution {
    public int numDecodings(String s) {
        int n = s.length() ;
        int dp[] = new int[n+1] ;
        dp[0] = 1 ;
        int cur = 0 , prev = 0 ;
        for(int i = 1 ; i <= n ; i++){
            prev = cur ;
            cur = s.charAt(i-1) - '0' ;
            int val = prev*10 + cur ;
            if(cur != 0){
                dp[i] += dp[i-1] ;
            }
            if(val >= 10 && val <=26){
                dp[i] += dp[i-2] ;
            }
        }
        return dp[n] ;
    }
}