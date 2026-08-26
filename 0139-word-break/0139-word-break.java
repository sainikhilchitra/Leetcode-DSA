class Solution {
    HashSet<String> hs = new HashSet<>() ;
    public boolean solve(String s,int idx,int prev,String cur,Boolean[][] dp){
        if(idx == s.length()){
            return hs.contains(cur) ;
        }
        if(dp[idx][prev] != null) return dp[idx][prev] ;
        boolean ans = solve(s,idx + 1,prev,cur + s.charAt(idx),dp) ;
        if(hs.contains(cur)){
            System.out.println(idx+" "+cur) ;
            ans = ans || solve(s,idx + 1,idx + 1,s.charAt(idx)+"",dp) ;
        }
        return dp[idx][prev] = ans ;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict){
            hs.add(word) ;
        }
        Boolean dp[][] = new Boolean[s.length()][s.length()] ;
        return solve(s,0,0,"",dp) ;
    }
}