class Solution {

    int binarySearch(int arr[],int prefixMin[],int low,int high,int target){
        int ans = -1 ;

        while(low <= high){
            int mid = (low + high) / 2 ;
            if(arr[prefixMin[mid]] <= target){
                ans = prefixMin[mid] ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        return ans ;
    }
    public int maxWidthRamp(int[] nums) {

        int n = nums.length ;

        int prefixMin[] = new int[n] ;

        prefixMin[0] = 0 ;

        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[prefixMin[i - 1]]){
                prefixMin[i] = i ;
            }
            else{
                prefixMin[i] = prefixMin[i - 1] ;
            }
        }

        int maxWidth = 0 ;

        for(int i = 1 ; i < n ; i++){
            int j = binarySearch(nums,prefixMin,0,i - 1,nums[i]) ;

            if(j != -1){
                maxWidth = Math.max(i - j,maxWidth) ;
            }
        }

        return maxWidth ;
        
    }
}