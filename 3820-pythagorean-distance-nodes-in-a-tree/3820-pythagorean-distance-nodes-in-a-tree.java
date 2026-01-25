class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
        }

        long dx[] = bfs(graph,x,n) ;
        long dy[] = bfs(graph,y,n) ;
        long dz[] = bfs(graph,z,n) ;

        int ans = 0 ;
        for(int i = 0 ; i < n ; i++){
            long a = Math.max(dx[i],Math.max(dy[i],dz[i])) ;

            boolean trip = false ;
            if(a == dx[i]) {
                trip = (dy[i] * dy[i] + dz[i] * dz[i] == a * a);
            }
            else if(a == dy[i]){
                trip = (dx[i] * dx[i] + dz[i] * dz[i] == a * a);
            }
            else{
                trip = (dy[i] * dy[i] + dx[i] * dx[i] == a * a);
            }

            if(trip){
                ans++ ;
            }
        }

        return ans ;
    }

    long[] bfs(ArrayList<ArrayList<Integer>> graph,int src,int n){
        long[] dis = new long[n] ;
        Arrays.fill(dis,-1) ;
        dis[src] = 0 ;

        Queue<Integer> q = new LinkedList<>() ;
        q.offer(src) ;

        while(!q.isEmpty()){
            int x = q.poll() ;

            for(int y : graph.get(x)){
                if(dis[y] == -1){
                    dis[y] = dis[x] + 1 ;
                    q.offer(y) ;
                }
            }
        }

        return dis ;
    }
}