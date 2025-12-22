class Solution {
    List<List<Integer>> res = new ArrayList<>() ;
    void combinations(ArrayList<Integer> al,int idx,int k,int sum,int target,boolean used[],int usedIdx){
        if(idx == k){
            if(sum == target){
                res.add(new ArrayList(al)) ;
            }
            return ;
        }
        for(int i = usedIdx ; i < 10 ; i++){
            if(!used[i-1]){
                used[i-1] = true ;
                al.add(i) ;
                combinations(al,idx+1,k,sum+i,target,used,i+1) ;
                al.remove(al.size()-1) ;
                used[i-1] = false ;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinations(new ArrayList<>(),0,k,0,n,new boolean[9],1) ;
        return res ;
    }
}