class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length ;
        int right = nums[n - 1] ;
        int ans = 0 ;
        for(int i = n - k - 1 ; i >= 0 ; i--){
            right = Math.max(right,nums[i + k]) ;
            ans = Math.max(ans,nums[i] + right) ;
        }
        return ans ;
    }
}