class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean visited[],int src,int des){
        if(src == des) return true ;
        visited[src] = true ;

        for(int y : graph.get(src)){
            if(!visited[y] && dfs(graph,visited,y,des)){
                return true ;
            }
        }

        return false ;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        for(int i = 0 ; i < edges.length ; i++){
            int[] edge = edges[i] ;
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
        }

        return dfs(graph,new boolean[n],source,destination) ;
    }
}