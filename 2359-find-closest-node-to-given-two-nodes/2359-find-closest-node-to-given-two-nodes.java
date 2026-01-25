class Solution {
    int[] bfs(int[] graph,int src,int n){
        int dis[] = new int[n] ;
        Arrays.fill(dis,-1) ;

        dis[src] = 0 ;

        Queue<Integer> q = new LinkedList<>() ;
        q.offer(src) ;
        while(!q.isEmpty()){
            int x = q.poll() ;
            int y = graph[x] ;
            if(y != -1 && dis[y] == -1){
                dis[y] = dis[x] + 1 ;
                q.offer(y) ; 
            }
        }

        return dis ;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length ;
        int dist1[] = bfs(edges,node1,n) ;
        int dist2[] = bfs(edges,node2,n) ;

        int ansDis = Integer.MAX_VALUE ;
        int node = -1 ;
        for(int i = 0 ; i < n ; i++){

            if(dist1[i] == -1 || dist2[i] == -1) continue ;

            int dis = Math.max(dist1[i],dist2[i]) ;
            if(dis < ansDis){
                ansDis = dis ;
                node = i ;
            }
        }

        return node ;
    }
}