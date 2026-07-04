class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int count = 0 ;
        int idx = nums.length / 2 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == nums[idx]) count++ ;
        }
        return count == 1 ;
    }
}