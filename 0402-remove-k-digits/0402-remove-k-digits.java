class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length() ;

        Stack<Integer> stk = new Stack<>() ;

        for(int i = 0 ; i < n ; i++){
            int digit = num.charAt(i) - '0' ;
            while(!stk.isEmpty() && k > 0 && stk.peek() > digit){
                stk.pop() ;
                k-- ;
            }
            stk.push(digit) ;
        }

        while(k > 0 && !stk.isEmpty()){
            stk.pop() ;
            k-- ;
        }

        StringBuilder sb = new StringBuilder() ;

        int i = 0 ;
        while(i < stk.size() && stk.get(i) == 0) i++ ;

        for(; i < stk.size() ; i++){
            sb.append(stk.get(i)) ;
        }

        return sb.isEmpty() ? "0" : sb.toString() ;
    }
}