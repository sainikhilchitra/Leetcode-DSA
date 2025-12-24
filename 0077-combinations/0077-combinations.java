class Solution {
    List<List<Integer>> res = new ArrayList<>() ;
    void combinations(ArrayList<Integer> al,int start,int n,int k,int count,boolean visited[]){

        if(count == k){
            res.add(new ArrayList(al)) ;
            return ;
        }

        for(int i = start ; i <= n ; i++){
            if(!visited[i-1]){
                visited[i-1] = true ;
                al.add(i) ;
                combinations(al,i+1,n,k,count+1,visited) ;
                al.remove(al.size() - 1) ;
                visited[i-1] = false ;
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        combinations(new ArrayList<>(),1,n,k,0,new boolean[n]) ;
        return res ;
    }
}