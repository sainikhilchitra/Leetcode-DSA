class Solution {
    public int numOfWays(int n) {
        long mod = (long) 1e9 + 7 ;
        //ABC or ABA
        // initially 6 ways to select for ABC
        // initially 6 ways to select for ABA
        long prevDiff = 6 ;
        long prevSame = 6 ;
        long diff = 0 , same = 0 ;
        for(int i = 2 ; i <= n ; i++){
            diff = 2 * prevDiff + 2 * prevSame ;
            same = 3 * prevSame + 2 * prevDiff ;

            prevDiff = (diff) % mod ;
            prevSame = (same) % mod ;
        }

        return (int)((prevSame + prevDiff) % mod) ;
    }
}