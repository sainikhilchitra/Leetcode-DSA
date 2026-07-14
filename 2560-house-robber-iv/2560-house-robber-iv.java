class Solution {
    boolean check(int nums[],int target,int k){
        int count = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= target){
                count++ ;
                i++ ;
            }
        }
        return k <= count ;
    }
    public int minCapability(int[] nums, int k) {
        int low = nums[0], high = nums[0] ;
        for(int i = 0 ; i < nums.length ; i++){
            low = Math.min(low,nums[i]) ;
            high = Math.max(high,nums[i]) ;
        }
        int ans = -1 ;
        while(low <= high){
            int mid = high + (low - high) / 2 ;
            if(check(nums,mid,k)){
                ans = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return ans ;
    }
}