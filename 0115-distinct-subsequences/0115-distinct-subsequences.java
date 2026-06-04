class Solution {

    int subsequence(String s,String t,int i,int j,String cur,int dp[][]){
        if(j == t.length()){
            if(cur.equals(t)) return 1 ;
            return 0 ;
        }

        if(i == s.length()) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ;
        dp[i][j] = 0 ;

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = subsequence(s,t,i + 1,j + 1,cur + s.charAt(i),dp) ;
        }
        dp[i][j] += subsequence(s,t,i + 1,j,cur,dp) ;
        return dp[i][j] ;
    }
    public int numDistinct(String s, String t) {
        
        int dp[][] = new int[s.length()][t.length()] ;

        for(int i = 0 ; i < s.length() ; i++){
            Arrays.fill(dp[i], -1) ;
        }
        return subsequence(s,t,0,0,"",dp) ;
    }
}