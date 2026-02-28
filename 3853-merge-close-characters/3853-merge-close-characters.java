class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s) ;

        while(true){
            boolean changed = false ;

            for(int i = 0 ; i < sb.length() ; i++){
                for(int j = i + 1 ; j <= i + k && j < sb.length() ; j++){
                    if(sb.charAt(i) == sb.charAt(j)){
                        sb.deleteCharAt(j) ;
                        changed = true ;
                        break ;
                    }
                }
                if(changed) break ;
            }
            if(!changed){
                break ;
            }
        }

        return sb.toString() ;
    }
}