class Solution {
    List<String> res = new ArrayList<>() ;

    void bt(String s,int idx,String cur){
        if(idx == s.length()){
            res.add(cur) ;
            return ;
        }
        char ch = s.charAt(idx) ;
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            bt(s,idx + 1,cur + (char)(ch ^ 32)) ;
        }
        bt(s,idx + 1,cur + ch) ;
    }
    public List<String> letterCasePermutation(String s) {
        bt(s,0,"") ;
        return res ;
    }
}