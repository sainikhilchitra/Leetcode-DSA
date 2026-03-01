class Solution {
    public String trimTrailingVowels(String s) {
        HashSet<Character> hs = new HashSet<>() ;
        hs.add('a') ;
        hs.add('e') ;
        hs.add('i') ;
        hs.add('o') ;
        hs.add('u') ;

        int j = s.length() - 1 ;
        while(j >= 0 && hs.contains(s.charAt(j))){
            j-- ;
        }
        if(j == -1) return "" ;
        return s.substring(0,j + 1) ;
    }
}