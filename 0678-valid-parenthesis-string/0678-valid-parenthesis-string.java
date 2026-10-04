class Solution {
    boolean check(String s,int idx,int open,Boolean dp[][]){
        if(s.length() == idx){
            return open == 0 ;
        }
        if(dp[idx][open] != null) return dp[idx][open] ;
        boolean ans = false ;
        char ch = s.charAt(idx) ;
        if(ch == '('){
            ans = ans || check(s,idx + 1,open + 1,dp) ;
        }
        else if(ch == ')'){
            if(open <= 0) return false ;
            ans = ans || check(s,idx + 1,open - 1,dp) ;
        }
        else{
            if(open > 0){
                ans = ans || check(s,idx + 1,open - 1,dp) ;
            }
            ans = ans || check(s,idx + 1,open + 1,dp) || check(s,idx + 1,open,dp) ;
        }
        return dp[idx][open] = ans ;
    }
    public boolean checkValidString(String s) {
        Boolean dp[][] = new Boolean[s.length()][s.length()] ;
        return check(s,0,0,dp) ;
    }
}