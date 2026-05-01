class Solution {
    int idx = 0 ;
    public String decodeString(String s) {
        int num = 0 ;
        StringBuilder sb = new StringBuilder() ;
        int n = s.length() ;
        while(idx < n){
            char ch = s.charAt(idx++) ;
            if(ch == ']'){
                return sb.toString() ;
            }
            else if(ch == '['){
                String newString = decodeString(s) ;
                for(int i = 0 ; i < num ; i++){
                    sb.append(newString) ;
                }
                num = 0 ;
            }
            else if(ch >= '0' && ch <= '9'){
                num = num * 10 + (ch - '0') ;
            }
            else{
                sb.append(ch) ;
            }
        }

        return sb.toString() ;
    }
}