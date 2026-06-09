class Solution {
    
    String res = "" ;
    int count = 0 ;
    void bt(boolean visited[],String cur,int n,int k,int cur_count){
        if(cur_count == n){
            count++ ;
            if(count == k){
                res = cur ;
            }
            return ;
        }

        for(int i = 1 ; i <= n ; i++){
            if(!visited[i]){
                visited[i] = true ;
                bt(visited,cur + i, n,k,cur_count + 1) ;
                visited[i] = false ;
            }
        }
    }
    public String getPermutation(int n, int k) {
        bt(new boolean[n + 1],"",n,k,0) ;
        return res ;
    }
}