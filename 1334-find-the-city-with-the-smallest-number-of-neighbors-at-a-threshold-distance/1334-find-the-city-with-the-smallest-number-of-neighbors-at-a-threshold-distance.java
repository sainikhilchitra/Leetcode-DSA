class Solution {
    int dijkstra(ArrayList<ArrayList<int[]>> graph,int src,int threshold){
        int dist[] = new int[graph.size()] ;
        Arrays.fill(dist,Integer.MAX_VALUE) ;
        dist[src] = 0 ;
        HashSet<Integer> hs = new HashSet<>() ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]) ;
        pq.offer(new int[]{src,0}) ;
        while(!pq.isEmpty()){
            int temp[] = pq.poll() ;
            int u = temp[0], d = temp[1] ;
            if(d > threshold) continue ;
            hs.add(u) ;
            for(int y[] : graph.get(u)){
                int v = y[0] ;
                int newdis = d + y[1] ;
                if(newdis < dist[v]){
                    dist[v] = newdis ;
                    pq.offer(new int[]{v,newdis}) ;
                }
            }
        }
        return hs.size() ;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int edge[] : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]}) ;
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]}) ;
        }
        int min = n, ans = n - 1 ;
        for(int i = 0 ; i < n ; i++){
            int neighbors = dijkstra(graph,i,distanceThreshold) ;
            if(neighbors <= min){
                min = neighbors ;
                ans = i ;
            }
        }
        return ans ;
    }
}