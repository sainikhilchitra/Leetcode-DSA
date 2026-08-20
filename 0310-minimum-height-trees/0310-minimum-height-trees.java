class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            ArrayList<Integer> res = new ArrayList<>() ;
            res.add(0) ;
            return res ;
        } 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        int indegree[] = new int[n] ;
        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]) ;
            graph.get(edge[1]).add(edge[0]) ;
            indegree[edge[0]]++ ;
            indegree[edge[1]]++ ;
        }

        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 1) q.offer(i) ;
        }

        while(n > 2){
            int size = q.size() ;
            n -= size ;
            for(int k = 0 ; k < size ; k++){
                int x = q.poll() ;
                for(int y : graph.get(x)){
                    indegree[y]-- ;
                    if(indegree[y] == 1) q.offer(y) ;
                }
            }
        }
        return new ArrayList<>(q) ;
    }
}