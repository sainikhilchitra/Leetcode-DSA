class Solution {
    public int compress(char[] chars) {
        int n = chars.length ;

        int i = 1 ;
        StringBuilder sb = new StringBuilder(chars[0]+"") ;

        int count = 1 ;
        while(i < n){
            if(chars[i] != chars[i - 1]){
                if(count != 1){
                    sb.append(count) ;
                }
                sb.append(chars[i]) ;
                count = 1 ;
            }
            else{
                count++ ;
            }
            i++ ;
        }
        if(count != 1){
            sb.append(count);
        }

        for(i = 0 ; i < Math.min(sb.length(),n) ; i++){
            chars[i] = sb.charAt(i) ;
        }
        return sb.length() ;
    }
}