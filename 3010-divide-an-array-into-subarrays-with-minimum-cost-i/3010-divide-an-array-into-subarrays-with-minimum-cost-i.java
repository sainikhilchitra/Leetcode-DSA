class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0] ;
        
        int second = Math.min(nums[1],nums[2]) ;
        int third = Math.max(nums[1],nums[2]) ;

        for(int i = 3 ; i < nums.length ; i++){
            if(nums[i] <= second){
                third = second ;
                second = nums[i] ;
            }
            else if(nums[i] <= third){
                third = nums[i] ;
            }
        }

        return first + second + third ;
    }
}