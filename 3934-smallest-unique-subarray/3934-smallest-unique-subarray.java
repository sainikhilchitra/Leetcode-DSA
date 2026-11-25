class Solution {
    boolean isValid(int arr[],int n,int k){

        long base = 100001 ;
        long power = 1 ;
        long hash = 0, mod = (long) 1e9 + 7 ;

        HashMap<Long,Integer> hm = new HashMap<>() ;

        for(int i = 1 ; i < k ; i++){
            power = (power * base) % mod ;
        }

        for(int i = 0 ; i < k ; i++){
            hash = (hash * base + arr[i]) % mod ;
        }

        hm.put(hash,1) ;

        for(int i = k ; i < n ; i++){
            hash = (hash - (arr[i - k] * power) % mod + mod) % mod ;

            hash = (hash * base) % mod ;

            hash = (hash + arr[i]) % mod ;

            hm.put(hash,hm.getOrDefault(hash,0) + 1) ;
        }

        for(Map.Entry<Long,Integer> entry : hm.entrySet()){
            int freq = entry.getValue() ;
            if(freq == 1) return true ;
        }
        return false ;

    }
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length ;

        int low = 1, high = n,ans = n ;

        while(low <= high){
            int mid = (low + high) / 2 ;
            if(isValid(nums,n,mid)){
                ans = mid ;
                high = mid - 1 ;
            }
            else{
                low = mid + 1 ;
            }
        }

        return ans ;
    }
}