class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums) ;

        int n = nums.length ;

        int i = 0 , j = k - 1 ;

        int ans = nums[j] - nums[i] ;
        while(j < n){

            ans = Math.min(ans,nums[j] - nums[i]) ;
            j++ ;
            i++ ;
        }

        return ans ;
    }
}