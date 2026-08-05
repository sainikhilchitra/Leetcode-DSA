class Solution {
    ArrayList<Integer> perfectSquares = new ArrayList<>() ;
    public int numSquares(int n) {
        for(int i = 1 ; i * i <= 10000 ; i++){
            perfectSquares.add(i * i) ;
        }
        int dp[] = new int[n + 1] ;
        Arrays.fill(dp,-1) ;
        return numSquares(n,dp) ;
    }
    public int numSquares(int n,int dp[]){
        if(n == 0) return 0 ;
        if(n < 0) return (int) 1e7 ;
        if(dp[n] != -1) return dp[n] ;
        dp[n] = (int) 1e7 ;
        for(int i = 0 ; i < perfectSquares.size() ; i++){
            dp[n] = Math.min(dp[n],1 + numSquares(n - perfectSquares.get(i),dp)) ;
        }
        return dp[n] ;
    }
}