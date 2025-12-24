class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length ;
        boolean dp[] = new boolean[n] ;

        dp[0] = true ;

        for(int i = 0 ; i < n-1 ; i++){
            if(dp[i] == true ){
                int steps = nums[i] ;
                while(steps > 0){
                    if(i+steps < n){
                        dp[i+steps] = true ;
                    }
                    steps-- ;
                }
            }
        }
        return dp[n-1] ;
    }
}