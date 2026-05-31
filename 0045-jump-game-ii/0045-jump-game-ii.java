class Solution {
    int minJump(int idx,int nums[],int dp[]){
        if(idx == nums.length - 1) return 0 ;
        if(idx >= nums.length) return Integer.MAX_VALUE ;

        if(dp[idx] != -1) return dp[idx] ;
        dp[idx] = Integer.MAX_VALUE ;
        for(int i = 1 ; i <= nums[idx] ; i++){
            int next = minJump(idx + i,nums,dp) ;
            if(next != Integer.MAX_VALUE){
                dp[idx] = Math.min(dp[idx],1 + next) ;
            }
        }
        return dp[idx] ;
    }
    public int jump(int[] nums) {
        if(nums.length == 1) return 0 ;
        int dp[] = new int[nums.length] ;
        Arrays.fill(dp,-1) ;

        return minJump(0,nums,dp) ;
    }
}