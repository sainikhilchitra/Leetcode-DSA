class Solution {
    int dx[] = {0,0,1,-1} ;
    int dy[] = {1,-1,0,0} ;
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length ;
        int dp[][] = new int[n][m] ;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE) ;
        }
        dp[0][0] = 0 ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]) ;
        pq.offer(new int[]{0,0,0}) ;
        while(!pq.isEmpty()){
            int temp[] = pq.poll() ;
            int i = temp[1], j = temp[2] ;
            for(int move = 0 ; move < 4 ; move++){
                int ni = i + dx[move], nj = j + dy[move] ;
                if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue ;
                int cost = dp[i][j] + ((move + 1 == grid[i][j]) ? 0 : 1) ;
                if(cost < dp[ni][nj]){
                    dp[ni][nj] = cost ;
                    pq.offer(new int[]{cost,ni,nj}) ;
                }
            }
        }
        return dp[n - 1][m - 1] ;
    }
}