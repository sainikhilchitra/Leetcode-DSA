class Solution {
    int count=0;
    void combinations(int nums[],int n,int idx,int target,int sum){
        if(idx==n){
            if(sum==target) {
                count++;
            }
            return;
        }
        combinations(nums,n,idx+1,target,sum+nums[idx]) ;
        combinations(nums,n,idx+1,target,sum-nums[idx]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        combinations(nums,nums.length,0,target,0);
        return count;
    }
}