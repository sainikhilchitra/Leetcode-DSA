class Solution {

    boolean interleaving(String s1,String s2,String s3,int i,int j,int idx,Boolean dp[][]){
        if(i + j == s3.length()){
            return true ;
        }
        if(dp[i][j] != null) return dp[i][j] ;
        dp[i][j] = false ;
        if(i != s1.length() && s1.charAt(i) == s3.charAt(idx)){
            dp[i][j] = dp[i][j] || interleaving(s1,s2,s3,i + 1,j,idx + 1,dp) ;
        }
        if(j != s2.length() && s2.charAt(j) == s3.charAt(idx)){
            dp[i][j] = dp[i][j] || interleaving(s1,s2,s3,i,j + 1,idx + 1,dp) ;
        }
        return dp[i][j] ;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false ;
        Boolean dp[][] = new Boolean[s1.length() + 1][s2.length() + 1] ;
        return interleaving(s1,s2,s3,0,0,0,dp) ;
    }
}