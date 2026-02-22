class Solution {
    public boolean isDigitorialPermutation(int n) {
        long[] fact = new long[10] ;

        fact[0] = 1 ;

        for(int i = 1 ; i <= 9 ; i++){
            fact[i] = i * fact[i - 1] ;
        }

        long save = n ;
        long ans = 0 ;
        int count1[] = new int[10] ;
        while(n != 0){
            int rem = n % 10 ;
            count1[rem]++ ;
            ans += fact[rem] ;
            n = n / 10 ;
        }

        while(ans != 0){
            int rem = (int)(ans % 10) ;
            count1[rem]-- ;
            ans = ans / 10 ;
        }

        for(int i = 0 ; i < 10 ; i++){
            if(count1[i] != 0) return false ;
        }
        return true ;
    }
}