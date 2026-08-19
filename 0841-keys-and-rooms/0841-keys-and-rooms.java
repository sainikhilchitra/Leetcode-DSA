class Solution {
    void dfs(List<List<Integer>> graph,boolean visited[],int src){
        if(visited[src]) return ;
        visited[src] = true ;
        for(int y : graph.get(src)){
            dfs(graph,visited,y) ;
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size() ;
        boolean visited[] = new boolean[n] ;
        dfs(rooms,visited,0) ;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]) return false ;
        }
        return true ;
    }
}