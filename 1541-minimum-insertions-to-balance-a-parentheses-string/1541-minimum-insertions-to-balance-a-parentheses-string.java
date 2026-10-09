class Solution {
    public int minInsertions(String s) {
        int open = 0 ;
        int ans = 0 ;
        int i = 0 ;
        while(i < s.length()){
            char ch = s.charAt(i) ;
            if(ch == '('){
                open++ ;
                i++ ;
            }
            else{
                if(open == 0){
                    ans++ ;
                    open++ ;
                }
                if(i + 1 == s.length()){
                    ans++ ;
                    i++ ;
                }
                else if(s.charAt(i + 1) == ')'){
                    i += 2 ;
                }
                else{
                    ans++ ;
                    i++ ;
                }
                open-- ;
            }
        }
        ans += 2 * open ;
        return ans ;
    }
}