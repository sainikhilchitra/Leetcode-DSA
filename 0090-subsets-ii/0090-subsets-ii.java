class Solution {
    List<List<Integer>> res = new ArrayList<>() ;
    HashSet<ArrayList<Integer>> hs = new HashSet<>() ;
    public void subset(int nums[],int idx,ArrayList<Integer> temp){
        if(idx == nums.length){
            ArrayList<Integer> al = new ArrayList<>(temp) ;
            Collections.sort(al) ;
            if(!hs.contains(al)){
                res.add(al) ;
                hs.add(al) ;
            }
            return ;
        }

        temp.add(nums[idx]) ;
        subset(nums,idx + 1,temp) ;
        temp.remove(temp.size() - 1) ;
        
        subset(nums,idx + 1,temp) ;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subset(nums,0,new ArrayList<>()) ;
        return res ;
    }
}