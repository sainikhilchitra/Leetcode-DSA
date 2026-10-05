class Solution {
    int idx = 0 ;
    public int scoreOfParentheses(String s) {
        int score = 0 ;
        int open = 0 ;
        while(idx < s.length()){
            char ch = s.charAt(idx) ;
            idx++ ;
            if(ch == '('){
                if(s.charAt(idx) != ')'){
                    score += 2 * scoreOfParentheses(s) ;
                }
                else{
                    open++ ;
                }
                
            }
            else{
                if(open == 0) return score ;
                open-- ;
                score++ ;
            }
        }
        return score ;
    }
}