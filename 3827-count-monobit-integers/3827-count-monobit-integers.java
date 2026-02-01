class Solution {

    boolean isMonobit(int n){
        int bit = (n & 1) ;

        while(n != 0){
            if((n&1) != bit) return false ;
            n>>=1 ;
        }

        return true ;
    }
    public int countMonobit(int n) {

        int count = 1 ;
        for(int i = 1 ; i <= n ; i++){
            if(isMonobit(i)) count++ ;
        }

        return count ;
    }
}