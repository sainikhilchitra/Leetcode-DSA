class Solution {
    public int longestBalanced(String s) {
        int len = 0 ;
        for(int i=0;i<s.length();i++){
            int count[] = new int[26] ;
            for(int j=i;j<s.length() ;j++){
                count[s.charAt(j)-'a']++ ;
                if(isValid(count)){
                    len = Math.max(len,j-i+1) ;
                }
            }
        }
        return len ;
    }
    boolean isValid(int[] count){
        int val = 0;
        for(int i=0;i<26;i++){
            if(count[i]>0){
                if(val==0){
                    val = count[i] ;
                }
                else if(count[i]!=val){
                    return false ;
                }
            }
        }
        return true ;
    }
}