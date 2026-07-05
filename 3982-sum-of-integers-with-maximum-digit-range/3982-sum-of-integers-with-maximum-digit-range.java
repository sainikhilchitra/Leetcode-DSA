class Solution {
    public int maxDigitRange(int[] nums) {
        int sum = 0 ;
        int maxDigit = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, ele = nums[i] ;
            while(ele != 0){
                int rem = ele % 10 ;
                max = Math.max(max,rem) ;
                min = Math.min(min,rem) ;
                ele /= 10 ;
            }
            int digit = max - min ;
            if(digit > maxDigit){
                maxDigit = digit ;
                sum = nums[i] ;
            }
            else if(digit == maxDigit){
                sum += nums[i] ;
            }
        }
        return sum ;
    }
}