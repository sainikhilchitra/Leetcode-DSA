class Solution {

    List<List<String>> res = new ArrayList<>() ;

    boolean check(String s,int i,int j){

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false ;
            i++ ;
            j-- ;
        }
        return true ;
    }
    void valid(int idx,List<String> cur_par,String s){
        if(idx == s.length()){
            res.add(new ArrayList<>(cur_par)) ;
            return ;
        }

        for(int i = idx ; i < s.length() ; i++){
            if(check(s,idx,i)){
                cur_par.add(s.substring(idx,i + 1)) ;
                valid(i + 1,cur_par,s) ;
                cur_par.remove(cur_par.size() - 1) ;
            }
        }
    }
    public List<List<String>> partition(String s) {
        valid(0,new ArrayList<>(),s) ;
        return res ;
    }
}