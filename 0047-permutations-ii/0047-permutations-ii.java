class Solution {
    List<List<Integer>> res = new ArrayList<>() ;
    void permutations(ArrayList<Integer> al , int nums[] , int n , boolean[] visited){
        if(al.size() == n){
            res.add(new ArrayList<>(al)) ;
            return ;
        }
        for(int i = 0 ; i < n ; i++){
            if(visited[i]) continue ;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) continue ;
            
            visited[i] = true ;
            al.add(nums[i]) ;
            permutations(al,nums,n,visited) ;
            visited[i] = false ;
            al.remove(al.size() - 1) ;   
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums) ;
        int n = nums.length ;
        permutations(new ArrayList<>() , nums, n , new boolean[n]) ;
        return res ;
    }
}