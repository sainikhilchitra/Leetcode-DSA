class Solution {

    int[] toposort(ArrayList<ArrayList<Integer>> graph,int[] indegree,int n){
        int idx = -1 ;

        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i) ;
            }
        }

        int order[] = new int[n] ;
        while(!q.isEmpty()){
            int src = q.poll() ;
            order[++idx] = src ;
            for(int y : graph.get(src)){
                indegree[y]-- ;
                if(indegree[y] == 0){
                    q.offer(y) ;
                }
            }
        }

        if(idx != n - 1) return new int[0] ;
        return order ;
    }
    // using indegree of a and storing all dependencies of b as graph
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>()) ;
        }
        int indegree[] = new int[numCourses] ;
        int m = prerequisites.length ;

        for(int edge[] : prerequisites){
            graph.get(edge[1]).add(edge[0]) ;
            indegree[edge[0]]++ ;
        }
        return toposort(graph,indegree,numCourses) ;
    }
}