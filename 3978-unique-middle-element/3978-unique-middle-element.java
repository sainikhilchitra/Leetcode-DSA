class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        HashSet<Integer> hs = new HashSet<>() ;
        int low = 0, high = nums.length - 1 ;
        while(low < high){
            hs.add(nums[low]) ;
            hs.add(nums[high]) ;
            low++ ;
            high-- ;
        }
        return !hs.contains(nums[low]) ;
    }
}