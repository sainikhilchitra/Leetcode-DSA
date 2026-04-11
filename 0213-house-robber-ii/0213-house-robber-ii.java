class Solution {
    int robbing(int start,int end,int nums[]){
        int dp0[] = new int[end + 1] ;
        int dp1[] = new int[end + 1] ;

        for(int i = start ; i <= end ; i++){
            dp0[i] = Math.max(dp0[i - 1],dp1[i - 1]) ;
            dp1[i] = dp0[i - 1] + nums[i - 1] ;
        }

        return Math.max(dp0[end],dp1[end]) ;
    }
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n == 1) return nums[0] ;
        return Math.max(robbing(1, n - 1,nums), robbing(2, n, nums)) ;
    }
}