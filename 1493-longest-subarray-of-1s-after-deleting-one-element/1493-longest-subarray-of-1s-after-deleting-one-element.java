class Solution {
    public int longestSubarray(int[] nums) {
        
        boolean allOnes = true ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                allOnes = false ;
                break ;
            }
        }
        if(allOnes) return nums.length - 1 ;
        int i = 0,len = 0 ;
        boolean zero = false ;
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] == 0){
                while(zero){
                    if(nums[i] == 0){
                        zero = false ;
                    }
                    i++ ;
                }
                zero = true ;
                len = Math.max(len,j - i) ;
            }
            else{
                len = Math.max(len, j - i + (zero ? 0 : 1)) ;
            }
        }
        return len ;
    }
}