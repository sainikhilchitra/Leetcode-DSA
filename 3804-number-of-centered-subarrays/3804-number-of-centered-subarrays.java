class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length ;

        int ans = 0 ;

        for(int i = 0 ; i < n ; i++){
            HashSet<Long> hs = new HashSet<>() ;
            long sum = 0 ;
            for(int j = i ; j < n ; j++){
                sum += nums[j] ;
                hs.add((long)nums[j]) ;
                if(hs.contains(sum)){
                    ans++ ;
                }
            }
        }

        return ans ;
    }
}