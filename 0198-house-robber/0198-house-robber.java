class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n == 1) return nums[0] ;

        int dp0[] = new int[n + 1] ;
        int dp1[] = new int[n + 1] ;

        for(int i = 1 ; i <= n ; i++){
            dp0[i] = Math.max(dp1[i - 1], dp0[i - 1]) ;
            dp1[i] = dp0[i - 1] + nums[i - 1] ;
        }

        return Math.max(dp0[n],dp1[n]) ;
    }
}