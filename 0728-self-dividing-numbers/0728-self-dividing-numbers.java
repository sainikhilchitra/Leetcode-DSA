class Solution {
    boolean isSelfDivisible(int n){
        int original = n ;

        while(n != 0){
            int rem = n % 10 ;
            n = n / 10 ;
            if(rem == 0) return false ;
            if((original % rem) != 0) return false ;
        }

        return true ;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>() ;

        for(int i = left ; i <= right ; i++){
            if(isSelfDivisible(i)){
                res.add(i) ;
            }
        }

        return res ;
    }
}