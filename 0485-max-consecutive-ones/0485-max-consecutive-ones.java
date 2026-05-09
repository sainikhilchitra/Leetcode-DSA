class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0, len = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1){
                len++ ;
                maxLength = Math.max(maxLength, len) ;
            }
            else{
                len = 0 ;
            }
        }

        return maxLength ;
    }
}