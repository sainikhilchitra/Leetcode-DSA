class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length ;

        int prefix[] = new int[n] ;

        prefix[0] = nums[0] ;

        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i - 1] + nums[i] ;
        }

        HashMap<Integer,Integer> hm = new HashMap<>() ;
        int count = 0 ;

        for(int i = 0 ; i < n ; i++){
            int rem = prefix[i] % k ;
            if(rem < 0){
                rem += k ;
            }
            if(rem == 0) count++ ;
            if(hm.containsKey(rem)) count += hm.get(rem) ;

            hm.put(rem,hm.getOrDefault(rem,0) + 1) ;
        }

        return count ;
    }
}