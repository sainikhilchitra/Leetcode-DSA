class Solution {
    List<List<Integer>> res = new ArrayList<>() ;

    void traverse(int src,int graph[][],int n,ArrayList<Integer> path,boolean visited[]){
        if(src == n - 1){
            res.add(new ArrayList<>(path)) ;
            return ;
        }

        for(int y : graph[src]){
            if(visited[y]) continue ;
            visited[y] = true ;
            path.add(y) ;
            traverse(y,graph,n,path,visited) ;
            path.remove(path.size() - 1) ;
            visited[y] = false ;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length ;
        ArrayList<Integer> path = new ArrayList<>() ;
        path.add(0) ;
        traverse(0,graph,n,path,new boolean[n]) ;
        return res ;
    }
}