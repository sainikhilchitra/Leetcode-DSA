class Solution {
    void primeFactors(HashSet<Integer> hs,int n){
        int c = 0 ; 

        while(n % 2 == 0){
            n /= 2 ;
            c++ ;
        }

        if(c > 0) hs.add(2) ;

        for(int i = 3 ; i * i <= n ; i += 2){
            c = 0 ;
            while(n % i == 0){
                n /= i ;
                c++ ;
            }
            if(c > 0) hs.add(i) ;
        }

        if(n > 1) hs.add(n) ;
    }
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> hs = new HashSet<>() ;

        for(int i = 0 ; i < nums.length ; i++){
            primeFactors(hs,nums[i]) ;
        }

        return hs.size() ;
    }
}