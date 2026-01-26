class Solution {
    boolean dfs(int graph[][],int src,int color[],int curColor){
        if(color[src] != -1){
            return color[src] == curColor ;
        }

        color[src] = curColor ;
        for(int y : graph[src]){
            if(!dfs(graph,y,color,1 - curColor)) return false ;
        }

        return true ;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;

        int color[] = new int[n] ;
        Arrays.fill(color,-1) ;

        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(!dfs(graph,i,color,0)) return false ;
            }
        }

        return true ;
    }
}