class Solution {
    int bs(int arr[] , int low, int high){
        int idx = -1 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(arr[mid] < 0) {
                idx = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return idx ;
    }
    public int countNegatives(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            int idx =bs(grid[i],0,m-1) ;
            if(idx != -1){
                count += m - idx ;
            }
        }
        return count ;
    }
}