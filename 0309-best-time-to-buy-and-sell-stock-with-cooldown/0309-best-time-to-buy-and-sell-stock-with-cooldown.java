class Solution {
    // 0 - sell
    // 1 - buy
    // 2 - cooldown
    int buysell(int idx,int stock,int prices[],int dp[][]){
        if(idx == prices.length) return 0 ;
        if(dp[idx][stock] != -1) return dp[idx][stock] ;

        if(stock == 0){
            dp[idx][stock] = Math.max(prices[idx] + buysell(idx + 1,2,prices,dp),buysell(idx + 1,0,prices,dp)) ;
        }
        else if(stock == 1){
            dp[idx][stock] = Math.max(-prices[idx] + buysell(idx + 1,0,prices,dp),buysell(idx + 1,1,prices,dp)) ;
        }
        else{
            dp[idx][stock] = buysell(idx + 1,1,prices,dp) ;
        }

        return dp[idx][stock] ;
    }
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[prices.length][3] ;

        for(int i = 0 ; i < prices.length ; i++){
            Arrays.fill(dp[i],-1) ;
        }
        return buysell(0,1,prices,dp) ;
    }
}