class Solution {
    int floorBinary(int[] nums,int target,int low,int high){
        int idx=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                idx=mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return idx;
    }
    int ceilBinary(int []nums,int target,int low,int high){
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int arr[]=new int[2];
        arr[0]=floorBinary(nums,target,0,nums.length-1);
        arr[1]=ceilBinary(nums,target,0,nums.length-1);
        return arr;
    }
}