class Solution {

    List<List<Integer>> res = new ArrayList<>() ;
    HashSet<ArrayList<Integer>> hs = new HashSet<>() ;
    void bt(int nums[],int idx,int prev,ArrayList<Integer> cur){
        if(idx == nums.length){
            if(cur.size() > 1 && !hs.contains(cur)){
                res.add(new ArrayList<>(cur)) ;
                hs.add(new ArrayList<>(cur)) ;
            }
            return ;
        }

        if(nums[idx] >= prev){
            cur.add(nums[idx]) ;
            bt(nums,idx + 1,nums[idx],cur) ;
            cur.remove(cur.size() - 1) ;
        }
        bt(nums,idx + 1,prev,cur) ;
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        bt(nums,0,Integer.MIN_VALUE,new ArrayList<>()) ;
        return res ;
    }
}