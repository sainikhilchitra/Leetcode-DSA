class Solution {
    HashSet<Integer> hs = new HashSet<>() ;
    public void solve(int digits[],boolean visited[],int ans,int count){
        if(count == 3){
            if(ans >= 100 && ans <= 999 && ans % 2 == 0){
                hs.add(ans) ;
            }
            return ;
        }
        for(int i = 0 ; i < digits.length ; i++){
            if(!visited[i]){
                visited[i] = true ;
                solve(digits,visited,ans * 10 + digits[i],count + 1) ;
                visited[i] = false ;
            }
        }
    }
    public int totalNumbers(int[] digits) {
        solve(digits,new boolean[digits.length],0,0) ;
        return hs.size() ;
    }
}