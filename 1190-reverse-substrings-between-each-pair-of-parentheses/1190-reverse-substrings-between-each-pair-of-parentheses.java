class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stk = new Stack<>() ;
        for(char ch : s.toCharArray()){
            if(ch != ')'){
                stk.push(ch+"") ;
            }
            else{
                String temp = "" ;
                while(!stk.peek().equals("(")){
                    StringBuilder sb = new StringBuilder(stk.pop()) ;
                    temp += sb.reverse().toString() ;
                }
                stk.pop() ;
                stk.push(temp) ;
            }
        }
        String ans = "" ;
        for(int i = 0 ; i < stk.size() ; i++){
            ans += stk.get(i) ;
        }
        return ans ;
    }
}