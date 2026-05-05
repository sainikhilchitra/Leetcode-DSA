class Solution {
    public int countPrimes(int n) {
        boolean nonPrime[] = new boolean[n + 1] ;

        for(int i = 2 ; i * i <= n ; i++){
            if(nonPrime[i]) continue ;
            for(int j = 2 * i ; j <= n ; j += i){
                nonPrime[j] = true ;
            }
        } 
        int count = 0 ;
        for(int i = 2 ; i < n ; i++){
            if(!nonPrime[i]) count++ ;
        }

        return count ;
    }
}