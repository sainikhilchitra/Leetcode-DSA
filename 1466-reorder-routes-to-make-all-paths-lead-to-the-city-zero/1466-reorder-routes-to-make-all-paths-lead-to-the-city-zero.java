class Solution {
    int dfs(ArrayList<ArrayList<int[]>> graph,int src,boolean visited[]){
        if(visited[src]) return 0 ;
        visited[src] = true ;
        int count = 0 ;
        for(int y[] : graph.get(src)){
            if(visited[y[0]]) continue ;
            count += dfs(graph,y[0],visited) + (y[1] == 0 ? 1 : 0) ;
        }
        return count ;
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        for(int edge[] : connections){
            graph.get(edge[0]).add(new int[]{edge[1],0}) ;
            graph.get(edge[1]).add(new int[]{edge[0],1}) ;
        }
        return dfs(graph,0,new boolean[n]) ;
    }
}