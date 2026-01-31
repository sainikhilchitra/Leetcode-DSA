class Solution {
    boolean isValid(long k,int nums[]){
        long sum = 0 ;
        for(int ele : nums){
            sum += (ele + k - 1) / k ;
        }

        return sum <= k * k ;
    }
    public int minimumK(int[] nums) {

        long low = 1, high = nums[0] ;
        long max = nums[0] ;
        for(int ele : nums){
            max = Math.max(max,ele) ;
        }

        high = Math.max(nums.length,max) ;
        while(low <= high){
            long mid = (low + high) / 2 ;

            if(isValid(mid,nums)){
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        return (int)low ;
    }
}