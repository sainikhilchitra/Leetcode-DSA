class Solution {
    boolean stringMatch(String s1,String s2,int idx1,int idx2,Boolean dp[][]){
        if(idx1 == s1.length()){
            return idx2 == s2.length() ;
        }
        if(dp[idx1][idx2] != null) return dp[idx1][idx2] ;
        dp[idx1][idx2] = false ;
        boolean firstMatch = idx2 < s2.length() && (s1.charAt(idx1) == s2.charAt(idx2) || s1.charAt(idx1) == '.') ;
        if(idx1 + 1 != s1.length() && s1.charAt(idx1 + 1) == '*'){
            dp[idx1][idx2] = (firstMatch && stringMatch(s1,s2,idx1,idx2 + 1,dp)) || stringMatch(s1,s2,idx1 + 2,idx2,dp) ;
        }
        else{
            dp[idx1][idx2] = (firstMatch && stringMatch(s1,s2,idx1 + 1,idx2 + 1,dp)) ;
        }
        return dp[idx1][idx2] ;
    }
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[p.length() + 1][s.length() + 1] ;
        return stringMatch(p,s,0,0,dp) ;
    }
}