class Solution {
    int binarySearch(int arr[],int low,int high,int target){
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(arr[mid] == target) return mid ;
            else if(arr[mid] > target) high = mid - 1 ;
            else low = mid + 1 ;
        }
        return -1 ;
    }
    public int minOperations(int[] nums, int x) {
        int n = nums.length ;
        int prefix[] = new int[n + 1] ;
        for(int i = 1 ; i <= n ; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1] ;
        }
        int ans = Integer.MAX_VALUE ;
        int sum = 0 ;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(prefix[i] == x) ans = Math.min(ans,i) ;
            sum = sum + nums[i] ;
            int temp = binarySearch(prefix,0,i,x - sum) ;
            if(temp == -1) continue ;
            ans = Math.min(ans,temp + n - i) ;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
}