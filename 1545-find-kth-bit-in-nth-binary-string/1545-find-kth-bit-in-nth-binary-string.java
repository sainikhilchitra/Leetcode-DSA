class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0' ;

        int mid = (1 << (n - 1)) ;

        if(mid == k) return '1' ;

        if(mid < k){
            char ch = findKthBit(n - 1, (1 << n) - k) ;
            return ch == '1' ? '0' : '1' ;
        }
        return findKthBit(n - 1,k) ;
    }
}