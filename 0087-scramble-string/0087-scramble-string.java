class Solution {
    HashMap<String,Boolean> hm = new HashMap<>() ;
    boolean solve(String s1,String s2){
        int n = s1.length() ;
        if(n == 1){
            return s1.charAt(0) == s2.charAt(0) ;
        }
        String s = s1+'#'+s2 ;
        if(hm.containsKey(s)) return hm.get(s) ;
        boolean nonswap = false, swap = false ;
        for(int i = 0 ; i < n - 1 ; i++){
            nonswap = nonswap || solve(s1.substring(0,i + 1),s2.substring(0,i + 1)) && solve(s1.substring(i + 1,n),s2.substring(i + 1,n));
            swap = swap || solve(s1.substring(0,i + 1),s2.substring(n - (i + 1),n)) && solve(s1.substring(i + 1,n),s2.substring(0,n - (i + 1)));
            if(swap || nonswap) break ;
        }
        hm.put(s,nonswap || swap) ;
        return hm.get(s) ;
    }
    public boolean isScramble(String s1, String s2) {
        return solve(s1,s2) ;
    }
}