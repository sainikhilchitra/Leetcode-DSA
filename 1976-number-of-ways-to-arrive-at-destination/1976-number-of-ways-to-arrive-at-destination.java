class Pair{
    int x ;
    long time ;
    Pair(int x,long time){
        this.x = x ;
        this.time = time ;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        int mod = (int) 1e9 + 7 ; 
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int[] edge : roads){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2])) ;
            graph.get(edge[1]).add(new Pair(edge[0],edge[2])) ;
        }

        long time[] = new long[n] ;
        long ways[] = new long[n] ;
        
        Arrays.fill(time,Long.MAX_VALUE) ;
        Arrays.fill(ways,0) ;

        time[0] = 0 ;
        ways[0] = 1 ;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll() ;

            int x = p.x ;
            long curTime = p.time ;
            if (curTime > time[x]) continue;

            for(Pair y : graph.get(x)){

                long newTime = y.time + curTime ;

                if(newTime == time[y.x]){
                    ways[y.x] = (ways[y.x] + ways[x]) % mod ;
                }
                else if(newTime < time[y.x]){
                    time[y.x] = newTime ;
                    ways[y.x] = ways[x] ;
                    pq.offer(new Pair(y.x,newTime)) ;
                }

            }  
        }

        return (int)ways[n - 1] ;
    }
}