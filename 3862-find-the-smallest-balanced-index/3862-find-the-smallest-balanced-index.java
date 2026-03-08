class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length ;
        
        // it is given that n = 10^5 so at max it will reach 10 ^ 14

        long maxProduct = (long) 1e15 ;
        long suffix[] = new long[n] ;

        Arrays.fill(suffix,maxProduct) ;

        suffix[n - 1] = 1 ;

        for(int i = n - 2 ; i >= 0 ; i--){

            if(suffix[i + 1] > maxProduct / nums[i + 1]){
                suffix[i] = maxProduct ;
                break ;
            }
            else{
                suffix[i] = suffix[i + 1] * nums[i + 1] ;
            }
        }

        long sum = 0 ; 

        for(int i = 0 ; i < n ; i++){
            if(sum == suffix[i]) return i ;
            sum += nums[i] ;
        }
        return -1 ;
    }
}