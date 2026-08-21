class Pair{
    int v ;
    double p ;
    Pair(int v,double p){
        this.v = v ;
        this.p = p ;
    }
}
class Solution {
    double dijkstra(ArrayList<ArrayList<Pair>> graph,int src,int des){
        double prob[] = new double[graph.size()] ;
        prob[src] = 1.0 ;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.p,a.p)) ;
        pq.offer(new Pair(src,1.0)) ;
        while(!pq.isEmpty()){
            Pair temp = pq.poll() ;
            int u = temp.v ;
            double p = temp.p ;
            for(Pair y : graph.get(u)){
                int v = y.v ;
                double newp = p * y.p ;
                if(newp > prob[v]){
                    prob[v] = newp ;
                    pq.offer(new Pair(v,newp)) ;
                }
            }
        }
        return prob[des] ;
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        for(int i = 0 ; i < edges.length ; i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i])) ;
            graph.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i])) ;
        }
        return dijkstra(graph,start_node,end_node) ;
    }
}