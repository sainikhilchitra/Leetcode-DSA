class Solution {
    public int maxDepth(String s) {
        Stack<Integer> stk = new Stack<>() ;
        int ans = 0 ;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stk.push(1) ;
            }
            else if(ch == ')'){
                stk.pop() ;
            }
            ans = Math.max(ans,stk.size()) ;
        }
        return ans ;
    }
}