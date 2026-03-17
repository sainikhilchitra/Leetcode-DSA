class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;

        long curFuel = startFuel ;

        int i = 0, n = stations.length,count = 0 ;
        while(curFuel < target){
            while(i < n && stations[i][0] <= curFuel){
                pq.offer(stations[i][1]) ;
                i++ ;
            }

            if(pq.isEmpty()) return -1 ;

            curFuel += pq.poll() ;
            count++ ;
        }

        return count ;
        
    }
}