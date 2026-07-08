class Solution {
    List<List<Integer>> sub=new ArrayList<>();
    void generate(ArrayList<Integer> al,int idx,int n,int nums[]){
        if(idx==n){
            //Add the list to the sub
            sub.add(new ArrayList<>(al));
            return;
        }
        al.add(nums[idx]);
        generate(al,idx+1,n,nums);
        al.remove(al.size()-1);
        generate(al,idx+1,n,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        generate(al,0,nums.length,nums);
        return sub;
    }
}
