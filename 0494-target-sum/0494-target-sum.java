class Solution {
    int solve(int nums[],int target,int idx,int sum,int dp[][]){
        if(idx == nums.length){
            if(sum == target) return 1 ;
            return 0 ;
        }
        if(dp[idx][sum + 1000] != -1) return dp[idx][sum + 1000] ;
        dp[idx][sum + 1000] = solve(nums,target,idx + 1,sum + nums[idx],dp) ;
        dp[idx][sum + 1000] += solve(nums,target,idx + 1,sum - nums[idx],dp) ;
        return dp[idx][sum + 1000] ;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int dp[][] = new int[nums.length][2001] ;
        for(int i = 0 ; i < nums.length ; i++){
            Arrays.fill(dp[i],-1) ;
        }
        return solve(nums,target,0,0,dp) ;
    }
}