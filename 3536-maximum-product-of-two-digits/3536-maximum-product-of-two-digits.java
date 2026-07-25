class Solution {
    public int maxProduct(int n) {
        int res[] = new int[10] ;
        int idx = 0 ;
        while(n != 0){
            res[idx] = n % 10 ;
            n = n / 10 ;
            idx++ ;
        }
        Arrays.sort(res) ;
        return res[9] * res[8] ;
    }
}