class Solution {
    public int[] rearrangeArray(int[] nums) {
        int count[] = new int[101] ;
        for(int ele : nums){
            count[ele]++ ;
        }
        int n = nums.length, idx = 0 ;
        int ans[] = new int[n] ;
        while(idx < n){
            for(int i = 0 ; i <= 100 ; i++){
                if(count[i] > 0){
                    ans[idx++] = i ;
                    count[i]-- ;
                }
            }
        }
        return ans ;
    }
}