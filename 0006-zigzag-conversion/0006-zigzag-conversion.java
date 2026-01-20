class Solution {
    public String convert(String s, int numRows) {
        int n = s.length() ;
        if(numRows == 1 || numRows > n) return s ;

        StringBuilder[] rows = new StringBuilder[numRows] ;

        for(int i = 0 ; i < numRows ; i++){
            rows[i] = new StringBuilder() ;
        }

        boolean goingDown = false ;
        int curRow = 0 ;
        for(char ch : s.toCharArray()){
            rows[curRow].append(ch) ;
            if(curRow == 0 || curRow == numRows - 1){
                goingDown = !goingDown ;
            }

            if(goingDown){
                curRow++ ;
            }
            else{
                curRow-- ;
            }
        }

        StringBuilder res = new StringBuilder() ;

        for(StringBuilder sb : rows){
            res.append(sb) ;
        }

        return res.toString() ;
    }
}