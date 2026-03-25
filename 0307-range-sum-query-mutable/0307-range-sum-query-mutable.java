class NumArray {
    int seg[] ;
    int n ;
    public NumArray(int[] nums) {
        n = nums.length ;
        seg = new int[4 * n] ;
        build(nums,0,0,n - 1) ;
    }
    
    void build(int arr[],int idx,int low,int high){
        if(low == high){
            seg[idx] = arr[low] ;
            return ;
        }

        int mid = (low + high) / 2 ;
        build(arr,2*idx + 1,low,mid) ;
        build(arr,2*idx + 2,mid + 1,high) ;
        seg[idx] = seg[2*idx + 1] + seg[2*idx + 2] ;
    }
    void updateSegment(int idx,int low,int high,int node,int val){
        if(low == high){
            seg[idx] = val ;
            return ;
        }

        int mid = (low + high) / 2 ;

        if(node <= mid){
            updateSegment(2*idx + 1,low,mid,node,val) ;
        }
        else{
            updateSegment(2*idx + 2,mid + 1,high,node,val) ;
        }

        seg[idx] = seg[2*idx + 1] + seg[2*idx + 2] ;
    }
    public void update(int index, int val) {
        updateSegment(0,0,n - 1,index,val) ;
    }
    
    int sumSegment(int idx,int low,int high,int l,int r){
        if(high < l || low > r) return 0 ;

        if(low >= l && high <= r) return seg[idx] ;
        
        int mid = (low + high) / 2 ;
        return sumSegment(2*idx + 1,low,mid,l,r) + sumSegment(2*idx + 2,mid + 1,high,l,r) ;
    }
    public int sumRange(int left, int right) {
        return sumSegment(0,0,n - 1,left,right) ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */