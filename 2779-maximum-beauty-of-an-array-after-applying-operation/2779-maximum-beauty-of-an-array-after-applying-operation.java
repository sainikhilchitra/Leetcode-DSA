class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        int len = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = nums[i] + k ;
            len = Math.max(len,nums[i] + k) ;
        }

        int count[] = new int[len + 2] ;

        for(int i = 0 ; i < nums.length ; i++){
            count[nums[i] - k]++ ;
            count[nums[i] + k + 1]-- ;
        }

        int max = count[0] ;

        for(int i = 1 ; i < len + 2 ; i++){
            count[i] += count[i - 1] ;
            max = Math.max(max,count[i]) ;
        }

        return max ;
    }
}