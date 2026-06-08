class Solution {
    int ceil(int nums[],int target){
        int ans = nums.length ;
        int low = 0,high = nums.length - 1 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(nums[mid] >= target){
                ans = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        return ans ;
    }

    public int hIndex(int[] citations) {
        int low = 0, high = citations.length ;

        int ans = 0 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(citations.length - ceil(citations,mid) >= mid){
                ans = mid ;
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }

        return ans ;
    }
}