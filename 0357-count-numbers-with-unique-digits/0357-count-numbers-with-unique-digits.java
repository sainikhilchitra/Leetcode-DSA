class Solution {
    int uniqueCount(int i,int f,int g,int used,String n){

        // f = 1 it is not having any limit
        // g = 0 => still  there is no non - zero number used

        if(n.length() == i) return 1 ;

        int lim = n.charAt(i) - '0' ;
        if(f == 1) lim = 9 ;

        int count = 0 ;
        if(g == 0){
            count += uniqueCount(i + 1,1,0,used,n) ;
        }

        for(int dig = 0 ; dig <= lim ; dig++){
            if(g == 0 && dig == 0) continue ;

            if((used & (1 << dig)) != 0) continue ;

            int nused = (used | (1 << dig)) ;

            if(dig < lim){
                count += uniqueCount(i + 1,1,1,nused,n) ;
            }
            else{
                count += uniqueCount(i + 1,f,1,nused,n) ;
            }

        }

        return count ;
    }
    public int countNumbersWithUniqueDigits(int n) {
        n = (int) Math.pow(10,n) - 1 ;
        return uniqueCount(0,0,0,0,n + "") ;
    }
}