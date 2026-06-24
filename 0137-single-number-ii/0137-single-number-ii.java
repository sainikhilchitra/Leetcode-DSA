class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0 ;
        for(int i = 32 ; i >= 0 ; i--){
            int sum = 0 ;
            for(int j = 0 ; j < nums.length ; j++){
                if(((nums[j] >> i) & 1) != 0) sum++ ;
            }
            ans <<= 1 ;
            ans |= (sum % 3) ;
        }
        return ans ;
    }
}