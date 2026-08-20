class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        int indegree[] = new int[n] ;
        int dist[] = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        for(int edge[] : relations){
            graph.get(edge[0] - 1).add(edge[1] - 1) ;
            indegree[edge[1] - 1]++ ;
        }
        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i) ;
                dist[i] = time[i] ;
            }
        }

        while(!q.isEmpty()){
            int x = q.poll() ;
            for(int y : graph.get(x)){
                indegree[y]-- ;
                dist[y] = Math.max(dist[y],dist[x] + time[y]) ;
                if(indegree[y] == 0){
                    q.offer(y) ;
                }
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,dist[i]) ;
        }
        return max ;
    }
}