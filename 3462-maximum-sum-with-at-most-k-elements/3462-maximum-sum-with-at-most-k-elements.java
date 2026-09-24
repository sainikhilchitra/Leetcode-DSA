class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a) ;
        for(int i = 0 ; i < grid.length ; i++){
            Arrays.sort(grid[i]) ;
        }

        for(int i = 0 ; i < grid.length ; i++){
            int l = limits[i] ;
            for(int j = grid[i].length - 1 ; j >= 0 && l > 0 ; j--){
                pq.offer(grid[i][j]) ;
                l-- ;
            }
        }
        long sum = 0 ;
        while(k > 0 && !pq.isEmpty()){
            sum += pq.poll() ;
            k-- ;
        }
        return sum ;
    }
}