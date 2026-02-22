class Solution {
    public int scoreDifference(int[] nums) {

        int arr[] = new int[2] ;

        int active = 0 ;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(i % 6 == 5){
                active = 1 - active ;
            }
            if(nums[i] % 2 == 1){
                active = 1 - active ;
            }
            arr[active] += nums[i] ;
        }

        return arr[0] - arr[1] ;
    }
}