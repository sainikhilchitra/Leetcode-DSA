class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length ;
        int dp[] = new int[target + 1] ;
        dp[0] = 1 ;
        for(int i = 1 ; i <= target ; i++){
            for(int steps : nums){
                if(steps <= i){
                    dp[i] += dp[i-steps] ;
                }
            }
        }
        return dp[target] ;
    }
}