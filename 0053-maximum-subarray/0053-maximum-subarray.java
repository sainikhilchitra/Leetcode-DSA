class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE, n = nums.length ;
        int curSum = 0 ;
        for(int i = 0 ; i < n ; i++){

            if(curSum + nums[i] < nums[i]){
                curSum = 0 ;
            }

            curSum += nums[i] ;
            maxSum = Math.max(maxSum,curSum) ;
        }

        return maxSum ;
    }
}