class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length() ;
        int count[] = new int[26] ;
        int ans = 0, i = 0, maxFreq = 0 ;
        for(int j = 0 ; j < length ; j++){
            char ch = s.charAt(j) ;
            count[ch - 'A']++ ;
            maxFreq = Math.max(maxFreq,count[ch - 'A']) ;
            while(j - i + 1 - maxFreq > k){
                count[s.charAt(i) - 'A']-- ;
                i++ ;
            }
            ans = Math.max(ans,j - i + 1) ;
        }
        return ans ;
    }
}