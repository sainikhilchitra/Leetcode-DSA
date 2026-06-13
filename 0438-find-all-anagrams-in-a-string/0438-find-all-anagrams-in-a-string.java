class Solution {
    boolean check(int count1[],int count2[]){
        for(int i = 0 ; i < 26 ; i++){
            if(count1[i] != count2[i]) return false ;
        }
        return true ;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>() ;
        List<Integer> res = new ArrayList<>() ;

        int count1[] = new int[26] ;
        int count2[] = new int[26] ;
        int n = p.length() ;
        for(int i = 0 ; i < n ; i++){
            count1[p.charAt(i) - 'a']++ ;
            count2[s.charAt(i) - 'a']++ ;
        }
        if(check(count1,count2)){
            res.add(0) ;
        }

        for(int i = n ; i < s.length() ; i++){
            count2[s.charAt(i - n) - 'a']-- ;
            count2[s.charAt(i) - 'a']++ ;
            if(check(count1,count2)){
                res.add(i - n + 1) ;
            }
        }
        return res ;
    }
}