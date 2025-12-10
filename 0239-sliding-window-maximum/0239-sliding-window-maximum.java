class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>() ;
        int n = nums.length;
        int arr[] = new int[n-k+1];
        for(int i = 0 ; i < k ; i++ ){
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
        }
        arr[0] = nums[q.peekFirst()];
        for(int i = k ; i < n ; i++ ){
            if(i-k == q.peekFirst()){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
            arr[i-k+1] = nums[q.peekFirst()] ;
        }
        return arr;
    }
}