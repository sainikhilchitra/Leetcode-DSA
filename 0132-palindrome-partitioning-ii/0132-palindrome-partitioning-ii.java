class Solution {

    boolean check(String s,int i,int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false ;
            i++ ;
            j-- ;
        }

        return true ;
    }

    int partition(int idx,int prev,String s,int dp[][]){
        if(s.length() == idx) return 0 ;

        if(dp[prev][idx] != -1) return dp[prev][idx] ;

        dp[prev][idx] = s.length() ;
        for(int i = idx ; i < s.length() ; i++){
            if(check(s,prev,i)){
                dp[prev][idx] = Math.min(dp[prev][idx],1 + partition(i + 1,i + 1,s,dp)) ;
            }
        }

        return dp[prev][idx] ;
    }

    public int minCut(String s) {
        
        int n = s.length() ;

        int dp[][] = new int[n][n] ;

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1) ;
        }

        return partition(0,0,s,dp) - 1 ;
    }
}