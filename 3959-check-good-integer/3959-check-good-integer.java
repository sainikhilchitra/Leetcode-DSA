class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0 ;
        int square = 0 ;

        while(n != 0){
            int rem = n % 10 ;
            square = square  + (rem * rem) ;
            sum = sum + rem ;
            n /= 10 ;
        }

        return square - sum >= 50 ;
    }
}