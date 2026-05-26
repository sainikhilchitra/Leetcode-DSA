class Solution {
    public int numberOfSpecialChars(String word) {
        
        boolean characters[] = new boolean[256] ;
        

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i) ;
            characters[ch] = true ;
        }
        
        int count = 0 ;
        for(int i = 0 ; i < 26 ; i++){
            if(characters[i + 'a'] && characters[i + 'A']) count++ ;
        }

        return count ;
    }
}