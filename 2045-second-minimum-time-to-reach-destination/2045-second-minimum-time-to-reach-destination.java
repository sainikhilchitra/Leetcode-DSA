class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
        }

        int dist[][] = new int[n + 1][2] ;
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE) ;
        }
        dist[1][0] = 0 ;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]) ;
        pq.offer(new int[]{1,0}) ;
        while(!pq.isEmpty()){
            int temp[] = pq.poll() ;
            int u = temp[0] ;
            int t = temp[1] ;
            if((t / change) % 2 == 1){
                t = (t / change + 1) * change ;
            }
            for(int y : graph.get(u)){
                int newdis = t + time ;
                if(newdis < dist[y][0]){
                    dist[y][1] = dist[y][0] ;
                    dist[y][0] = newdis ;
                    pq.offer(new int[]{y,newdis}) ;
                }
                else if(newdis > dist[y][0] && newdis < dist[y][1]){
                    dist[y][1] = newdis ;
                    pq.offer(new int[]{y,newdis}) ;
                }
            }
        }
        return dist[n][1] ;
    }
}