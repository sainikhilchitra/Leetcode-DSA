class Solution {

    boolean check(String s,int i,int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false ;
            i++ ;
            j-- ;
        }

        return true ;
    }

    void fillPalindrome(boolean palindrome[][],String s,int n,int i,int j){
        while(i >= 0 && j < n){
            if(s.charAt(i) != s.charAt(j)) return ;
            palindrome[i][j] = true ;
            i-- ;
            j++ ;
        }
    }

    int partition(int idx,int prev,String s,int dp[][],boolean palindrome[][]){
        if(s.length() == idx) return 0 ;

        if(dp[prev][idx] != -1) return dp[prev][idx] ;

        dp[prev][idx] = s.length() ;
        for(int i = idx ; i < s.length() ; i++){
            if(palindrome[prev][i]){
                dp[prev][idx] = Math.min(dp[prev][idx],1 + partition(i + 1,i + 1,s,dp,palindrome)) ;
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

        boolean palindrome[][] = new boolean[n][n] ;
        for(int i = 0 ; i < n ; i++){
            fillPalindrome(palindrome,s,n,i,i + 1) ;
            fillPalindrome(palindrome,s,n,i,i) ;
        }

        return partition(0,0,s,dp,palindrome) - 1 ;
    }
}