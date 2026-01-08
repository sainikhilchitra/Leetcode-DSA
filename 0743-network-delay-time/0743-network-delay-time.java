class Pair{
    // same class is acting as v,w and dist,node
    int first ;
    int second ;
    Pair(int first,int second){
        this.first = first ;
        this.second = second ;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int[] edge : times){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2])) ;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.first - b.first) ;
        int dist[] = new int[n + 1] ;
        Arrays.fill(dist,Integer.MAX_VALUE) ;
        dist[k] = 0 ;
        pq.offer(new Pair(0,k)) ;

        while(!pq.isEmpty()){
            Pair p = pq.poll() ;

            int curNode = p.second ;
            int curDist = p.first ;

            for(Pair y : graph.get(curNode)){
                int adjacentNode = y.first ;
                int weight = y.second ;
                int totalDist = curDist + weight ;
                if(totalDist < dist[adjacentNode]){
                    dist[adjacentNode] = totalDist ;
                    pq.offer(new Pair(totalDist,adjacentNode)) ;
                }
            }
        }
        int ans = 0 ;
        for(int i = 1 ; i <= n ; i++){
            if(i == k) continue ;
            if(dist[i] == Integer.MAX_VALUE) return -1 ;
            ans = Math.max(ans,dist[i]) ;
        }

        return ans ;
    }
}