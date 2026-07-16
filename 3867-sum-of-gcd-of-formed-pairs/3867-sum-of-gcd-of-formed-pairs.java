class Solution {
    int gcd(int a,int b){
        if(a == 0) return b ;
        return gcd(b % a,a) ;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length ;
        int prefix[] = new int[n] ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,nums[i]) ;
            prefix[i] = gcd(max,nums[i]) ;
        }
        Arrays.sort(prefix) ;
        int i = 0, j = n - 1 ;
        long ans = 0 ;
        while(i < j){
            ans += gcd(prefix[i],prefix[j]) ;
            i++ ;
            j-- ;
        }
        return ans ;
    }
}