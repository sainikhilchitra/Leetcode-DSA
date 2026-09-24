class Solution {
    int sumOfDigits(int ele){
        int sum = 0 ;
        while(ele != 0){
            sum += ele % 10 ;
            ele /= 10 ;
        }
        return sum ;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(i == sumOfDigits(nums[i])) return i ;
        }
        return -1 ;
    }
}