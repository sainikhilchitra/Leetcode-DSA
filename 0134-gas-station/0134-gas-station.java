class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int  n = gas.length, idx = 0 ;
        long total = 0, cur = 0 ;
        for(int i = 0 ; i < n ; i++){
            long diff = gas[i] - cost[i] ;
            total += diff ;
            cur += diff ;
            if(cur < 0){
                idx = i + 1 ;
                cur = 0 ;
            }
        }
        if(total < 0) return -1 ;
        return idx ;
    }
}