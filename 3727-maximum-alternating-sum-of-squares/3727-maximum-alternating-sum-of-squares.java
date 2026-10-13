class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            nums[i] = Math.abs(nums[i]) ;
        }
        Arrays.sort(nums) ;
        int mid = n / 2 ;
        long ans = 0 ;
        for(int i = mid ; i < n ; i++){
            ans += 1L * nums[i] * nums[i] ;
        }
        for(int i = 0 ; i < mid ; i++){
            ans -= 1L * nums[i] * nums[i] ;
        }
        return ans ;
    }
}