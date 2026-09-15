class Solution {
    int solve(String s,int idx,int prev,int k,boolean palindrome[][],int dp[][]){
        if(idx == s.length()) return 0 ;
        if(dp[prev][idx] != -1) return dp[prev][idx] ;
        int ans = 0 ;
        if(idx - prev + 1 >= k && palindrome[prev][idx]){
            ans = Math.max(ans,1 + solve(s,idx + 1,idx + 1,k,palindrome,dp)) ;
        }
        ans = Math.max(ans,solve(s,idx + 1,prev,k,palindrome,dp)) ;
        ans = Math.max(ans,solve(s,idx + 1,idx + 1,k,palindrome,dp)) ;
        return dp[prev][idx] = ans ;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length() ;
        boolean palindrome[][] = new boolean[n][n] ;
        for(int i = 0 ; i < n ; i++){
            constructPalindrome(palindrome,s,i,i + 1) ;
            constructPalindrome(palindrome,s,i,i) ;
        }
        int dp[][] = new int[n][n] ;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1) ;
        }
        return solve(s,0,0,k,palindrome,dp) ;
    }

    void constructPalindrome(boolean palindrome[][],String s,int i,int j){
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) != s.charAt(j)) break ;
            palindrome[i][j] = true ;
            i-- ;
            j++ ;
        }
    }
}