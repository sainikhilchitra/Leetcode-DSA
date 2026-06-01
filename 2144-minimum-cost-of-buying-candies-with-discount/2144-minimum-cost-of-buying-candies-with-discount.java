class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost) ;

        int i = cost.length - 1 ;
        
        int ans = 0 ;
        while(i > 1){
            ans += cost[i] + cost[i - 1] ;
            i = i - 3 ;
        }

        while(i >= 0){
            ans += cost[i--] ;
        }

        return ans ;
    }
}