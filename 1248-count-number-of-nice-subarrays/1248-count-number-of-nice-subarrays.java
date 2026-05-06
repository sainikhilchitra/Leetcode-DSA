class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length ;

        int prefix[] = new int[n] ;
        
        int pre = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 != 0) pre++ ;
            prefix[i] = pre ;
        }

        HashMap<Integer,Integer> hm = new HashMap<>() ;

        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(prefix[i] == k) count++ ;
            if(hm.containsKey(prefix[i] - k)) count += hm.get(prefix[i] - k) ;
            hm.put(prefix[i], hm.getOrDefault(prefix[i], 0) + 1) ;
        }

        return count ;
    }
}