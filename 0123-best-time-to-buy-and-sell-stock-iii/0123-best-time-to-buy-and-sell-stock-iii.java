class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length ;

        int suffix[] = new int[n] ;
        
        int mx = prices[n - 1], mpro = 0 ;
        for(int i = n - 2 ; i >= 0 ; i--){
            int cpro = mx - prices[i] ;
            mpro = Math.max(mpro,cpro) ;
            mx = Math.max(mx,prices[i]) ;
            suffix[i] = mpro ;
        }

        mpro = 0 ;
        int mn = prices[0], res = 0 ;

        for(int i = 1 ; i < n ; i++){
            int cpro = prices[i] - mn ;
            mpro = Math.max(mpro,cpro) ;
            mn = Math.min(mn,prices[i]) ;

            if(i != n - 1){
                res = Math.max(res,mpro + suffix[i + 1]) ;
            }
            else{
                res = Math.max(res,mpro) ;
            }
        }

        return res ;
    }
}