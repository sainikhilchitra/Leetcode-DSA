class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = 1L * k1 + k2 ;
        int n = nums1.length ;
        int diff[] = new int[n] ;
        int low = 0, high = 0 ;
        long total = 0 ;
        for(int i = 0 ; i < n ; i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]) ;
            total += diff[i] ;
            high = Math.max(high,diff[i]) ;
        }
        if(total <= k) return 0 ;
        int target = high ;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            long operation = 0 ;
            for(int d : diff){
                if(d > mid){
                    operation += d - mid ;
                }
            }
            if(operation <= k){
                target = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(diff[i] > target){
                k -= diff[i] - target ;
                diff[i] = target ;
            }
        }
        for(int i = 0 ; i < n && k > 0 ; i++){
            if(diff[i] < target) continue ;
            k-- ;
            diff[i] = diff[i] - 1 ;
        }

        long ans = 0 ;
        for(long d : diff){
            ans += d * d ;
        }
        return ans ;
    }
}