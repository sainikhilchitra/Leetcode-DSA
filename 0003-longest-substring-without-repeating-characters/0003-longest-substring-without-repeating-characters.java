class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 256 - all characters.
        boolean count[] = new boolean[256] ;
        int n = s.length() ;
        int i = 0, j = 0, ans = 0 ;
        while(j < n){
            char ch = s.charAt(j) ;
            
            while(i < j && count[ch]){
                char ch2 = s.charAt(i) ;
                count[ch2] = false ;
                i++ ;
            }
            count[ch] = true ;
            ans = Math.max(ans,j - i + 1) ;
            j++ ;
        }

        return ans ;
    }
}