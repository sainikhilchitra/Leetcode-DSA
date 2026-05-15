class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length ;
        int curMax = 0, maxSum = Integer.MIN_VALUE ;
        int curMin = 0, minSum = Integer.MAX_VALUE ;
        int totalSum = 0 ;
        for(int i = 0 ; i < n ; i++){
            curMax = Math.max(nums[i],curMax + nums[i]) ;
            curMin = Math.min(nums[i],curMin + nums[i]) ;

            maxSum = Math.max(maxSum,curMax) ;
            minSum = Math.min(minSum,curMin) ;

            totalSum += nums[i] ;
           
        }

        if(maxSum < 0) return maxSum ;
        return Math.max(maxSum, totalSum - minSum) ;
    }
}