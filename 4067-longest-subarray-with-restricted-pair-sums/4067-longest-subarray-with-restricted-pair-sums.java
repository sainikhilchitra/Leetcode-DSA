class Solution {
    public int maxSubarray(int[] nums) {
        int ans = 1, n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            int freq[] = new int[501] ;
            for(int j = i ; j < n ; j++){
                int x = nums[j] ;
                boolean invalid = false ;
                for(int a = 1 ; a <= x / 2 ; a++){
                    int b = x - a ;
                    if(freq[a] > 0 && freq[b] > 0){
                        if(a != b || freq[a] >= 2){
                            invalid = true ;
                            break ;
                        }
                    }
                }
                if(!invalid){
                    for(int a = 1 ; a + x <= 500 ; a++){
                        int b = a + x ;
                        if(freq[a] > 0 && freq[b] > 0){
                            invalid = true ;
                            break ;
                        }
                    }
                }
                if(invalid) break ;
                freq[x]++ ;
                ans = Math.max(ans,j - i + 1) ;
            }
        }
        return ans ;
    }
}