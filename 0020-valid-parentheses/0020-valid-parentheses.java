class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> hm=new HashMap<>();
        hm.put('}','{');
        hm.put(')','(');
        hm.put(']','[');
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stk.push(ch);
            }
            else{
                if(stk.isEmpty() || stk.peek()!=hm.get(ch)){
                    return false;
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}