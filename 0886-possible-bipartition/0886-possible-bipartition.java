class Pair{
    int i ;
    int j ;
    Pair(int i,int j){
        this.i = i ; 
        this.j = j ;
    }
}
class Solution {

    boolean isBipartite(ArrayList<ArrayList<Integer>> graph,int src,int grp[],int curGrp){
        if(grp[src] != -1){
            return grp[src] == curGrp ;
        }

        grp[src] = curGrp ;
        for(int y : graph.get(src)){
            if(!isBipartite(graph,y,grp,1 - curGrp)) return false ;
        }

        return true ;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int edge[] : dislikes){
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
        }

        int grp[] = new int[n + 1] ;
        Arrays.fill(grp,-1) ;
        for(int i = 1 ; i <= n ; i++){
            if(grp[i] == -1){
                if(!isBipartite(graph,i,grp,0)) return false ;
            }
        }
        return true ;
    }
}