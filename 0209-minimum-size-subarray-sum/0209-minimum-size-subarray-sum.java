class Solution {
    boolean isValid(int arr[],int n,long target,int k){
        long sum = 0 ;
        for(int i = 0 ; i < k ; i++){
            sum += arr[i] ;
            if(sum >= target) return true ;
        }
        
        for(int i = k ; i < n ; i++){
            sum += arr[i] ;
            sum -= arr[i - k] ;
            if(sum >= target) return true ;
        }

        return false ;
    }
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length ;
        int low = 1, high = n,ans = 0 ;

        while(low <= high){
            int mid = (low + high) / 2 ;

            if(isValid(nums,n,target,mid)){
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