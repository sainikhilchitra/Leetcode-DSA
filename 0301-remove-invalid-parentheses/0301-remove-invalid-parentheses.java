class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> al = new ArrayList<>();
        int open = 0 , close = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                open++;
            }else if(c == ')') {
                if(open > 0){
                    open--;
                }else{
                    close++;
                }
            }
        }
        backtrack(s , open , close , 0 , al);
        return al;
    }
    public static void backtrack(String s , int open , int close , int idx ,List<String> al){
        if(open == 0 && close == 0){
            if(isValid(s)){
                al.add(s);
            }
            return;
        }
        for(int i = idx ; i < s.length() ; i++){
            if(i > idx && s.charAt(i) == s.charAt(i - 1)){
                continue;
            }
            if(open > 0 && s.charAt(i) == '('){
                String str = s.substring(0 , i) + s.substring(i + 1);
                backtrack(str , open - 1 , close , i , al);
            }
            if(close > 0 && s.charAt(i) == ')'){
                String str = s.substring(0 , i) + s.substring(i + 1);
                backtrack(str , open , close - 1 , i , al);
            }
        }
    }
    public static boolean isValid(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}