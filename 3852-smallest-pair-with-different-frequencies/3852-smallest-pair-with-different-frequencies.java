class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        if(nums.length == 1 || nums.length == 2) {
            int res[] = new int[2] ;
            Arrays.fill(res,-1) ;
            return res ;
        }
        int count[] = new int[101] ;

        for(int i = 0 ; i < nums.length ; i++){
            count[nums[i]]++ ;
        }

        int res[] = new int[2] ;

        for(int i = 0 ; i <= 100 ; i++){
            if(count[i] == 0) continue ;
            if(res[0] == 0){
                res[0] = i ;
            }
            else if(count[res[0]] != count[i]){
                res[1] = i ;
                break ;
            }
        }
        if(res[1] == 0){
            Arrays.fill(res,-1) ;
        } 
        return res ;
    }
}