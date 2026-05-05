class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0 ;
        int steps = 0 ;
        int c = 0 ;
        while(n % 2 == 0){
            n /= 2 ;
            c++ ;
            if(c > 0) steps += 2 ;
        }


        for(int i = 3 ; i * i <= n ; i += 2){
            c = 0 ;
            while(n % i == 0){
                n /= i ;
                c++ ;
                if(c > 0) steps += i ;
            }
        }

        if(n > 1) steps += n ;

        return steps ;
    }
}