class Solution {
    public String maximumXor(String s, String t) {
        StringBuilder sb = new StringBuilder() ;

        int count = 0 ;

        for(char ch : t.toCharArray()){
            if(ch == '1') count++ ;
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0' && count > 0){
                sb.append('1') ;
                count-- ;
            }
            else{
                sb.append('0') ;
            }
        }
            int n = s.length() - 1;
            while(count > 0 && n >= 0){
                if(sb.charAt(n) != '1'){
                    sb.setCharAt(n,'1') ;
                    count-- ;
                }
                n-- ;
            }

            t = sb.toString() ;
            StringBuilder res = new StringBuilder() ;

            for(int j = 0 ; j < s.length() ; j++){
                if(s.charAt(j) != t.charAt(j)){
                    res.append('1') ;
                }
                else{
                    res.append('0') ;
                }
            }
        return res.toString() ;
    }
}