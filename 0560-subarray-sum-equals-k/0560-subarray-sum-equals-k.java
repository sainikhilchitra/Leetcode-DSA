class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length ;
        int prefix[] = new int[n] ;

        prefix[0] = nums[0] ;

        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i - 1] + nums[i] ;
        }
        
        int count = 0 ;
        HashMap<Integer,Integer> hm = new HashMap<>() ;

        for(int i = 0 ; i < n ; i++){
            if(prefix[i] == k) count++ ;
            if(hm.containsKey(prefix[i] - k)) count += hm.get(prefix[i] - k) ;
            hm.put(prefix[i],hm.getOrDefault(prefix[i],0) + 1) ;
        }

        return count ;
    }
}