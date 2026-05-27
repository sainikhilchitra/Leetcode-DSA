class Solution {
    int maximumProfit(int nums[],int i,int k,int stock,int transaction,Integer dp[][][]){
        if(transaction >= k) return 0 ;
        if(i >= nums.length) return 0 ;

        if(dp[i][stock][transaction] != null) return dp[i][stock][transaction] ;
        if(stock == 1){
            dp[i][stock][transaction] = Math.max(-nums[i] + maximumProfit(nums,i + 1,k,0,transaction,dp),maximumProfit(nums,i + 1,k,1,transaction,dp)) ;
        }
        else{
            dp[i][stock][transaction] = Math.max(nums[i] + maximumProfit(nums,i + 1,k,1,transaction + 1,dp),maximumProfit(nums,i + 1,k,0,transaction,dp)) ;
        }

        return dp[i][stock][transaction] ;
    }
    public int maxProfit(int k, int[] prices) {

        int n = prices.length ;
        Integer dp[][][] = new Integer[n][2][k] ;

        return maximumProfit(prices,0,k,1,0,dp) ;

    }
}