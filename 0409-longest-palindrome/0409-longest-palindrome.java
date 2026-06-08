class Solution {

    public int longestPalindrome(String s) {
        
        int count[] = new int[256] ;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            count[ch]++ ;
        }

        boolean single = false ;
        int len = 0 ;
        for(int i = 0 ; i < 256 ; i++){
            if(count[i] >= 2){
                len += (count[i] / 2 * 2) ;
            }

            if(count[i] % 2 == 1){
                single = true ;
            }
        }

        if(single) len++ ;
        return len ;
    }
}