class Solution {
    double power(double base,int exp){
        if(exp == 0) return 1 ;
        double val = power(base,exp/2) ;
        if(exp % 2 == 0){
            return val * val ;
        }
        return val * val * base ;
    }
    public double myPow(double x, int n) {
        double ans = power(Math.abs(x),Math.abs(n)) ;
        if(x < 0 && n % 2 != 0){
            ans = - ans ;
        }
        if(n < 0){
            return 1/ans ;
        }
        return ans ;
    }
}