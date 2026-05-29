class Solution {

    List<List<String>> res = new ArrayList<>() ;

    boolean check(String s){
        int i = 0, j = s.length() - 1 ;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false ;
            i++ ;
            j-- ;
        }
        return true ;
    }
    void valid(int idx,String cur,List<String> cur_par,String s){
        if(idx == s.length()){
            if(cur == ""){
                res.add(new ArrayList<>(cur_par)) ;
            }
            return ;
        }

        cur += s.charAt(idx) ;

        if(check(cur)){
            cur_par.add(cur) ;
            valid(idx + 1,"",cur_par,s) ;
            cur_par.remove(cur_par.size() - 1) ;
        }

        valid(idx + 1,cur,cur_par,s) ;
    }
    public List<List<String>> partition(String s) {
        valid(0,"",new ArrayList<>(),s) ;
        return res ;
    }
}