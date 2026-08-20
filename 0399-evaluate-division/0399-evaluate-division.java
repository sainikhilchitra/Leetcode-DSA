class Pair{
    int v ;
    double cost ;
    Pair(int v,double cost){
        this.v = v ;
        this.cost = cost ;
    }
}
class Solution {
    double dijktras(ArrayList<ArrayList<Pair>> graph,int src,int des){
        int n = graph.size() ;
        double[] dist = new double[n] ;
        Arrays.fill(dist,Double.MAX_VALUE) ;
        dist[src] = 1 ;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(a.cost,b.cost)) ;
        pq.offer(new Pair(src,1)) ;
        while(!pq.isEmpty()){
            Pair p = pq.poll() ;
            int u = p.v ;
            double cost = p.cost ;
            for(Pair y : graph.get(u)){
                int v = y.v ;
                if(dist[v] > cost * y.cost){
                    dist[v] = cost * y.cost ;
                    pq.offer(new Pair(v,dist[v])) ;
                }
            }
        }
        if(dist[des] == Double.MAX_VALUE) return -1.0 ;
        return dist[des] ;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,Integer> hm = new HashMap<>() ;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;
        int idx = 0 ;
        for(int i = 0 ; i < equations.size() ; i++){
            String edge[] = new String[2] ;
            edge[0] = equations.get(i).get(0) ;
            edge[1] = equations.get(i).get(1) ;

            int u, v ;
            if(!hm.containsKey(edge[0])){
                hm.put(edge[0],idx) ;
                idx++ ;
            }
            u = hm.get(edge[0]) ;
            if(!hm.containsKey(edge[1])){
                hm.put(edge[1],idx) ;
                idx++ ;
            }
            v = hm.get(edge[1]) ;

            if(graph.size() == u){
                graph.add(new ArrayList<>()) ;
            }
            if(graph.size() == v){
                graph.add(new ArrayList<>()) ;
            }
            graph.get(u).add(new Pair(v,values[i])) ;
            if(values[i] == 0) continue ;
            graph.get(v).add(new Pair(u,1 / values[i])) ;
        }

        double res[] = new double[queries.size()] ;
        for(int i = 0 ; i < queries.size() ; i++){
            int src = hm.getOrDefault(queries.get(i).get(0),-1) ;
            int des = hm.getOrDefault(queries.get(i).get(1),-1) ;
            if(src == -1 || des == -1){
                res[i] = -1.0 ;
                continue ;
            }
            res[i] = dijktras(graph,src,des) ;
        }
        return res ;
    }
}