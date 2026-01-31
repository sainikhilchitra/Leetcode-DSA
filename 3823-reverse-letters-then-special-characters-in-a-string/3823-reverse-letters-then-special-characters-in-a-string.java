class Solution {
    public String reverseByType(String s) {
        StringBuilder normal = new StringBuilder() ;
        StringBuilder special = new StringBuilder() ;

        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                normal.append(ch) ;
            }
            else{
                special.append(ch) ;
            }
        }

        normal.reverse() ;
        special.reverse() ;
        StringBuilder res = new StringBuilder() ;
        int i = 0 , j = 0 ;

        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                res.append(normal.charAt(i++)) ;
            }
            else{
                res.append(special.charAt(j++)) ;
            }
        }

        return res.toString() ;
    }
}