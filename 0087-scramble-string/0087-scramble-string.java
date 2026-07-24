class Solution {
    boolean solve(String s1,String s2,int idx1,int idx2,int len,Boolean dp[][][]){
        if(len == 1){
            return s1.charAt(idx1) == s2.charAt(idx2) ;
        }
        if(dp[idx1][idx2][len] != null) return dp[idx1][idx2][len] ;
        dp[idx1][idx2][len] = false ;
        boolean swap = false, nonswap = false ;
        for(int i = 1 ; i < len ; i++){
            nonswap = nonswap || (solve(s1,s2,idx1,idx2,i,dp) && solve(s1,s2,idx1 + i,idx2 + i,len - i,dp)) ;
            swap = swap || (solve(s1,s2,idx1,idx2 + len - i,i,dp) && solve(s1,s2,idx1 + i,idx2,len - i,dp)) ;
        }
        dp[idx1][idx2][len] = swap || nonswap ;
        return dp[idx1][idx2][len] ;
    }
    public boolean isScramble(String s1, String s2) {
        Boolean dp[][][] = new Boolean[s1.length() + 1][s1.length() + 1][s1.length() + 1] ;
        return solve(s1,s2,0,0,s1.length(),dp) ;
    }
}