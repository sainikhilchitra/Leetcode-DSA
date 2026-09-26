class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hm = new HashMap<>() ;
        for(int i = 0 ; i < knowledge.size() ; i++){
            hm.put(knowledge.get(i).get(0),knowledge.get(i).get(1)) ;
        }
        StringBuilder sb = new StringBuilder() ;
        int i = 0 ;
        while(i < s.length()){
            if(s.charAt(i) != '('){
                sb.append(s.charAt(i)) ;
            }
            else{
                i++ ;
                String temp = "" ;
                while(i < s.length() && s.charAt(i) != ')'){
                    temp += s.charAt(i) ;
                    i++ ;
                }
                if(hm.containsKey(temp)){
                    sb.append(hm.get(temp)) ;
                }
                else{
                    sb.append('?') ;
                }
            }
            i++ ;
        }
        return sb.toString() ;
    }
}