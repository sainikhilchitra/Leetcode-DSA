class Solution {

    boolean toposort(ArrayList<ArrayList<Integer>> graph,int[] indegree,int n){
        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i) ;
            }
        }

        while(!q.isEmpty()){
            int x = q.poll() ;
            for(int y : graph.get(x)){
                indegree[y]-- ;
                if(indegree[y] == 0){
                    q.offer(y) ;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] != 0) return false ;
        }

        return true ;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>()) ;
        }

        int indegree[] = new int[numCourses] ;
        for(int edge[] : prerequisites){
            graph.get(edge[1]).add(edge[0]) ;

            indegree[edge[0]]++ ;
        }

        return toposort(graph,indegree,numCourses) ;
    }
}