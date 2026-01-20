class Solution {
    public String convert(String s, int numRows) {
        int n = s.length() ;
        char mat[][] = new char[numRows][n] ;

        for(int i = 0 ; i < numRows ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = '0' ;
            }
        }
        int idx = 0 , i = 0 , col = 0 ;

        while(idx < n){
            i = 0;
            while(i < numRows && idx < n){
                mat[i][col] = s.charAt(idx) ;
                i++ ;
                idx++ ;
            }
            i -= 2 ;
            col++ ;

            while(i > 0 && idx < n){
                mat[i][col] = s.charAt(idx) ;
                idx++ ;
                i--;
                col++ ;
            }
        }

        StringBuilder sb = new StringBuilder() ;
        for(i = 0 ; i < numRows ; i++){
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] != '0'){
                    sb.append(mat[i][j]) ;
                }
            }
        }

        return sb.toString() ;
    }
}