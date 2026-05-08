class Solution {
    boolean isValid(int nums[],int n,int maxSum,int k){
        int sum = 0, count = 0 ;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i] ;
            if(sum > maxSum){
                sum = nums[i] ;
                count++ ;
            }
        }

        return count <= k ;
    }
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length ;
        int low = nums[0], high = nums[0] ;

        for(int i = 1 ; i < n ; i++){
            low = Math.max(low,nums[i]) ;
            high += nums[i] ;
        }

        int ans = low ;
        while(low <= high){
            int mid = (low + high) / 2 ;

            if(isValid(nums,n,mid,k - 1)){
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