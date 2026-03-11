class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length ;

        int leftMin = Integer.MAX_VALUE ;

        int maxDif = 0 ;
        for(int i = 1 ; i < n ; i++){
            leftMin = Math.min(leftMin, prices[i - 1]) ;
            maxDif = Math.max(maxDif,prices[i] - leftMin) ;
        }

        return maxDif ;
    }
}