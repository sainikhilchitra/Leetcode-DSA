class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<String,Integer> freq = new HashMap<>() ;
        int ans = 0 ;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i - 1] == nums[i]) ans++ ;
            else{
                String temp = nums[i - 1] + "#" + nums[i] ;
                freq.put(temp,freq.getOrDefault(temp,0) + 1) ;
            }
        }
        int max = 0 ;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i - 1] == nums[i]) continue ;
            String temp1 = nums[i - 1] + "#" + nums[i] ;
            String temp2 = nums[i] + "#" + nums[i - 1] ;
            max = Math.max(max,freq.getOrDefault(temp1,0) + freq.getOrDefault(temp2,0)) ;
        }
        return ans + max ;
    }
}