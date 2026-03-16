class Solution {

    StringBuilder compress(StringBuilder sb){
        StringBuilder s = new StringBuilder() ;

        int count = 1 ;

        for(int i = 1 ; i <= sb.length() ; i++){
            if(i == sb.length()){
                s.append(count).append(sb.charAt(i - 1)) ;
                break ;
            }
            if(sb.charAt(i - 1) != sb.charAt(i)){
                s.append(count).append(sb.charAt(i - 1)) ;
                count = 1 ;
            }
            else{
                count++ ;
            }
        }

        return s ;
    }
    public String countAndSay(int n) {
        
        StringBuilder sb = new StringBuilder() ;
        sb.append(1) ;
        for(int i = 2 ; i <= n ; i++){
            sb = compress(sb) ;
        }
        
        return sb.toString() ;
    }
}