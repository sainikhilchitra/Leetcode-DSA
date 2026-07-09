class Solution {
    int floor(int arr[],int target){
        int low = 0, high = arr.length - 1 ;
        int ans = 0 ;
        if(target >= arr[high]) return high ;
        if(target <= arr[low]) return low ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(arr[mid] <= target){
                ans = mid ;
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        return ans ;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length ;
        int closest = floor(arr,x) ;
        ArrayList<Integer> res = new ArrayList<>() ;
        int i = closest, j = i + 1 ;
        while(k > 0 && i >= 0 && j < n){
            int left = Math.abs(x - arr[i]) ;
            int right = Math.abs(x - arr[j]) ;
            if(left <= right){
                res.add(arr[i]) ;
                i-- ;
            }
            else{
                res.add(arr[j]) ;
                j++ ;
            }
            k-- ;
        }
        while(k > 0 && i >= 0){
            res.add(arr[i--]) ;
            k-- ;
        }
        while(k > 0 && j < n){
            res.add(arr[j++]) ;
            k-- ;
        }
        Collections.sort(res) ;
        return res ;
    }
}