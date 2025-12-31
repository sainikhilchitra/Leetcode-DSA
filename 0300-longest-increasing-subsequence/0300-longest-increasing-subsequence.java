class Solution {
    int ceilIdx(int small[],int low,int high,int target){
        int idx = 0 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(small[mid] < target){
                low = mid + 1 ;
            }
            else{
                idx = mid ;
                high = mid - 1 ;
            }
        }
        return idx ;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length ;
        int small[] = new int[n+1] ;
        int idx = 1 ;
        small[1] = nums[0] ;

        for(int i = 1 ; i < n ; i++){
            if(nums[i] > small[idx]){
                small[++idx] = nums[i] ;
            }
            else{
                int correctIndex = ceilIdx(small,1,idx,nums[i]) ;
                small[correctIndex] = nums[i] ;
            }
        }

        return idx ;
    }
}