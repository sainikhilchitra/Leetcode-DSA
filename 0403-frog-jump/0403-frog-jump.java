class Solution {
    boolean frog(int stones[],int idx,int k, Boolean dp[][]){
        if(idx == stones.length - 1){
            return true ;
        }
        if(dp[idx][k] != null) return dp[idx][k] ;
        dp[idx][k] = false ;
        int x[] = {-1,0,1} ;
        for(int next = 0 ; next < 3 ; next++){
            for(int i = idx + 1 ; i < stones.length ; i++){
                if(stones[i] > stones[idx] + k + x[next]) break ;
                if(stones[i] == stones[idx] + k + x[next]){       
                    dp[idx][k] = dp[idx][k] || frog(stones,i,k + x[next],dp) ;
                }
            }
        }
        return dp[idx][k] ;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length ;
        Boolean dp[][] = new Boolean[n][n] ;
        return frog(stones,0,0,dp) ;
    }
}