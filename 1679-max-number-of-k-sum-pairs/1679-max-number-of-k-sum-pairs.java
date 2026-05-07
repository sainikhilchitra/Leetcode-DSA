class Solution {
    public int maxOperations(int[] nums, int k) {
        //Approach 2 two pointer

        Arrays.sort(nums) ;

        int i = 0, j = nums.length - 1 ;

        int count = 0 ;
        while(i < j){
            int sum = nums[i] + nums[j] ;
            if(sum == k){
                count++ ;
                i++ ;
                j-- ;
            }
            else if(sum > k){
                j-- ;
            }
            else{
                i++ ;
            }
        }

        return count ;

        //Approach - 1 hashmap
        // HashMap<Integer,Integer> hm = new HashMap<>() ;
        // int n = nums.length ;

        // int count = 0 ;

        // for(int i = 0 ; i < n ; i++){
        //     if(hm.containsKey(k - nums[i])){
        //         count++ ;
        //         if(hm.get(k - nums[i]) == 1){
        //             hm.remove(k - nums[i]) ;
        //         }
        //         else{
        //             hm.put(k - nums[i],hm.get(k - nums[i]) - 1) ;
        //         }
        //     }
        //     else{
        //         hm.put(nums[i],hm.getOrDefault(nums[i],0) + 1) ;
        //     }
        // }

        // return count ;
    }
}