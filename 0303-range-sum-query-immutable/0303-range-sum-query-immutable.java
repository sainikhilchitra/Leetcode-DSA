class NumArray {

    long prefix[] ;
    int n ;
    public NumArray(int[] nums) {
        n = nums.length ;
        prefix = new long[n] ;

        prefix[0] = nums[0] ;

        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i - 1] + nums[i] ;
        }
    }
    
    public int sumRange(int left, int right) {
        long res = prefix[right] ;
        if(left != 0){
            res -= prefix[left - 1] ;
        }

        return (int) res ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */