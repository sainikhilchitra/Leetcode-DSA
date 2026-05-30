class Solution {
    public int maxProduct(int[] nums) {
        
        int maxPro = nums[0] ;

        int cur_max = nums[0], cur_min = nums[0] ;

        for(int i = 1 ; i < nums.length ; i++){
            int temp_max = Math.max(nums[i],Math.max(cur_max * nums[i],cur_min * nums[i])) ;
            int temp_min = Math.min(nums[i],Math.min(cur_max * nums[i],cur_min * nums[i])) ;
            cur_max = temp_max ;
            cur_min = temp_min ;
            maxPro = Math.max(maxPro,cur_max) ;
        }

        return maxPro ;
    }
}