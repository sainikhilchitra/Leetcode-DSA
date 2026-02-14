class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>() ;

        int n = nums.length ;

        for(int i = 0 ; i < n ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0) + 1) ;
        }

        int max = nums[0] ;
        for(int ele : nums){
            int freq = hm.get(ele) ;
            if(freq > hm.get(max)){
                max = ele ;
            }
        }

        return max ;
    }
}