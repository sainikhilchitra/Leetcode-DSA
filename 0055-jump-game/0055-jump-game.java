class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length ;
        int steps = nums[0] ;
        for(int i = 1 ; i < n ; i++){
            if(steps <= 0) return false ;
            steps-- ;
            steps = Math.max(steps,nums[i]) ;
        }
        return true ;
    }
}