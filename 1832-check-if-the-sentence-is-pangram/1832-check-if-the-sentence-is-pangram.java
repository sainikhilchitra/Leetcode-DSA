class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean came[] = new boolean[26] ;
        for(int i = 0 ; i < sentence.length() ; i++){
            came[sentence.charAt(i) - 'a'] = true ;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(!came[i]) return false ;
        }
        return true ;
    }
}