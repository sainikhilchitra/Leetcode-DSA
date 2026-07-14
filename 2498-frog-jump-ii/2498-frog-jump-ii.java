class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length ;
        int ans = 0 ;
        int i = 2 ;
        for(; i < n ; i += 2){
            ans = Math.max(ans,stones[i] - stones[i - 2]) ;
        }
        if(i == n){
            ans = Math.max(ans,stones[n - 1] - stones[n - 2]) ;
        }
        ans = Math.max(ans,stones[1] - stones[0]) ;
        for(i = 3 ; i < n ; i += 2){
            ans = Math.max(ans,stones[i] - stones[i - 2]) ;
        }
        if(i == n){
            ans = Math.max(ans,stones[n - 1] - stones[n - 2]) ;
        }
        return ans ;
    }
}