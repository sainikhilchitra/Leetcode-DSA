class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int count = 0 ;
        StringBuilder sb = new StringBuilder() ;
        while(sum > 0){
            if(count == num) return "" ;
            if(sum < 10){
                sb.append(sum) ;
                count++ ;
                break ;
            }
            sb.append(9) ;
            count++ ;
            sum -= 9 ;
        }
        while(count < num){
            sb.append(0) ;
            count++ ;
        }
        return sb.toString() ;
    }
}