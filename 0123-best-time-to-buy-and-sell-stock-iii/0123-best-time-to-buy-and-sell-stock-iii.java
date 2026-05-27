class Solution {

    int buySell(int prices[],int i,int buy,int transaction,Integer dp[][][]){
        // base case

        if(transaction == 2 || i == prices.length) return 0 ;
        int profit = 0 ;

        if(dp[i][buy][transaction] != null) return dp[i][buy][transaction] ;

        if(buy == 1){
             profit = Math.max(-prices[i] + buySell(prices,i + 1,0,transaction,dp),buySell(prices,i + 1,1,transaction,dp)) ;
        }
        else{
            profit = Math.max(prices[i] + buySell(prices,i + 1,1,transaction + 1,dp),buySell(prices,i + 1,0,transaction,dp)) ;
        }

        dp[i][buy][transaction] = profit ;

        return profit ;
    }

    public int maxProfit(int[] prices) {
        
        int n = prices.length ;

        Integer dp[][][] = new Integer[n][2][2] ;
        return buySell(prices,0,1,0,dp) ;
    }
}