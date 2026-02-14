class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length ;

        if(n == 1) return nums[0] ;

        long dp[] = new long[n] ;
        dp[0] = nums[0] ;

        if(colors[0] == colors[1]){
            dp[1] = Math.max(nums[0],nums[1]) ;
        }
        else{
            dp[1] = nums[0] + nums[1] ;
        }
        
        for(int i = 2 ; i < n ; i++){
            if(colors[i] == colors[i - 1]){
                dp[i] = Math.max(dp[i - 1] , dp[i - 2] + nums[i]) ;
            }
            else{
                dp[i] = dp[i - 1] + nums[i] ;
            }
        }
        return dp[n - 1];
    }
}