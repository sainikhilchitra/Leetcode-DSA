class Trio{
    int x ;
    int y ;
    int diff ;

    Trio(int x,int y,int diff){
        this.x = x ;
        this.y = y ;
        this.diff = diff ;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length ;
        int m = heights[0].length ;

        int dist[][] = new int[n][m] ;

        PriorityQueue<Trio> pq = new PriorityQueue<>((a,b) ->{
            return a.diff - b.diff ;
        }) ;

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE) ;
        }

        dist[0][0] = 0 ;
        pq.offer(new Trio(0,0,0)) ;

        int dx[] = {-1,0,1,0} ;
        int dy[] = {0,1,0,-1} ;
        
        int ans = Integer.MIN_VALUE ;
        while(!pq.isEmpty()){
            Trio t = pq.poll() ;

            for(int step = 0 ; step < 4 ; step++){
                int i = t.x + dx[step] ;
                int j = t.y + dy[step] ;
                if(i < 0 || j < 0 || i >= n || j >= m) continue ;
                int effort = Math.max(t.diff , Math.abs(heights[t.x][t.y] - heights[i][j])) ;

                if(effort < dist[i][j]){
                    dist[i][j] = effort ;
                    pq.offer(new Trio(i,j,effort)) ;
                }
            }
        }

        return dist[n - 1][m - 1] ;
    }
}