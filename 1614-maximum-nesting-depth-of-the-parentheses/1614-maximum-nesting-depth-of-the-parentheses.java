class Solution {
    public int maxDepth(String s) {
        int ans = 0, cur = 0 ;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                cur++ ;
            }
            else if(ch == ')'){
                cur-- ;
            }
            ans = Math.max(ans,cur) ;
        }
        return ans ;
    }
}