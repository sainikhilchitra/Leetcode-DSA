class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length ;
        if(n == 1) return true ;

        int min = Integer.MAX_VALUE ;

        for(int i = 0 ; i < n ; i++){
            if(nums1[i] % 2 != 0){
                min = Math.min(min,nums1[i]) ;
            }
        }

        if(min == Integer.MAX_VALUE) return true ;

        for(int i = 0 ; i < n ; i++){
            if(nums1[i] % 2 == 0 && nums1[i] < min) return false ;
        }

        return true ;
    }
}