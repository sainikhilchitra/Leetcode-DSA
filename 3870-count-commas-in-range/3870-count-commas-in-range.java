class Solution {
    public int countCommas(int n) {
        
        if(n < 1000) return 0 ;

        int count = 0 ;

        if(n > 9999) count = 9000 ;
        else return n - 1000 + 1 ;

        if(n == 100000){
            count++ ;
            n = n - 1 ;
        }

        count = count + n - 10000 + 1 ;

        return count ;
    }
}