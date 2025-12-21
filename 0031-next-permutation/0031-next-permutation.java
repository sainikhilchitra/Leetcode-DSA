class Solution {
    void swap(int arr[],int i,int j){
        arr[i] = arr[i] ^ arr[j] ;
        arr[j] = arr[i] ^ arr[j] ;
        arr[i] = arr[i] ^ arr[j] ;
    }
    public void nextPermutation(int[] nums) {
        int idx = -1 ;
        int n = nums.length ;
        for(int i = n - 2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                idx = i ;
                break ;
            }
        }
        if(idx == -1){
            Arrays.sort(nums);
            return ;
        }

        for(int i = n-1 ; i >= 0 ; i--){
            if(nums[i] > nums[idx]){
                swap(nums,i,idx) ;
                break ;
            }
        }
        int i = idx + 1 , j = n - 1 ;
        while( i < j ){
            swap(nums,i,j);
            i++ ;
            j-- ;
        }
    }
}