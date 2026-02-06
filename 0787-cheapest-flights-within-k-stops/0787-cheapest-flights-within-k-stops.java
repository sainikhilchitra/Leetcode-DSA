class Pair{

    //rep -> repeated(means stops)
    int port ;
    int price ;
    int rep ;
    Pair(int port,int price,int rep){
        this.port = port ;
        this.price = price ;
        this.rep = rep ;
    }
}
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int[] edge : flights){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2],0)) ;
        }

        int cost[][] = new int[n][k + 2] ;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE) ;
        }

        cost[src][0] = 0 ;

        if(src == dst) return 0 ;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return a.price - b.price ;
        }) ;

        pq.offer(new Pair(src,0,0)) ;

        while(!pq.isEmpty()){
                Pair p = pq.poll() ;
                int x = p.port ;
                int price = p.price ;
                int rep = p.rep ;

                if(rep > k) continue ;
                for(Pair y : graph.get(x)){
                    int newPrice = y.price + price ;

                    if(newPrice < cost[y.port][rep + 1]){
                        cost[y.port][rep + 1] = newPrice ;

                        pq.offer(new Pair(y.port,newPrice,rep + 1)) ;
                    }
                }
           
        }

        int ans = Integer.MAX_VALUE ;
        for(int i = 0 ; i <= k + 1 ; i++){
            ans = Math.min(cost[dst][i],ans) ;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans ;

    }
}