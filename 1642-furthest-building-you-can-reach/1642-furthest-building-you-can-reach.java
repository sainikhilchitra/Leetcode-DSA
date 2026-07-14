class Solution {
    boolean check(int nums[],int possible,int bricks,int ladders){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a) ;
        for(int i = 1 ; i <= possible ; i++){
            int dif = nums[i] - nums[i - 1] ;
            if(dif > 0){
                pq.offer(dif) ;
            }
        }
        while(!pq.isEmpty() && ladders != 0){
            pq.poll() ;
            ladders-- ;
        }
        while(!pq.isEmpty() && bricks >= pq.peek()){
            bricks -= pq.poll() ;
        }
        System.out.println(possible + " "+pq.size()) ;
        return pq.isEmpty() ;
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int low = 1, high = heights.length - 1 ;
        int ans = 0 ;
        while(low <= high){
            int mid = low - (low - high) / 2 ;
            if(check(heights,mid,bricks,ladders)){
                ans = mid ;
                low = mid + 1 ;
            }
            else{
                high = mid - 1 ;
            }
        }
        return ans ;
    }
}