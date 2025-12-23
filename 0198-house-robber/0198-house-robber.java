class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n == 1) return nums[0] ;

        int prev_2 = nums[0] ;
        int prev_1 = Math.max(prev_2,nums[1]) ;
        int cur = prev_1 ;
        for(int i = 2 ; i < n ; i++){
            cur = Math.max(prev_1,prev_2 + nums[i]) ;
            prev_2 = prev_1 ;
            prev_1 = cur ;
        }
        return cur ;
    }
}