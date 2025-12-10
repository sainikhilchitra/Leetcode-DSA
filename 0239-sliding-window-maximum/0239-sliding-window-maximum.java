class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a) ;
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        int n = nums.length ;
        int res[] = new int[n-k+1] ;
        for(int i=0;i<k;i++){
            pq.offer(nums[i]) ;
        }
        res[0] = pq.peek() ;
        for(int i=k;i<n;i++){
            pq.offer(nums[i]) ;
            hm.put(nums[i-k],hm.getOrDefault(nums[i-k],0) + 1) ;
            while(hm.containsKey(pq.peek())){
                int ele = pq.poll() ;
                hm.put(ele,hm.get(ele)-1) ;
                if(hm.get(ele) == 0){
                    hm.remove(ele) ;
                }
            }
            res[i-k+1] = pq.peek() ;
        }
        return res ;
    }
}