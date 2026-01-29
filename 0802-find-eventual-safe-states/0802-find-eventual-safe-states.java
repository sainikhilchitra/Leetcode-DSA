class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length ;
        int outDegree[] = new int[n] ;
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>() ;

        for(int i = 0 ; i < n ; i++){
            outDegree[i] = graph[i].length ;
            reverseGraph.add(new ArrayList<>()) ;
        }

        for(int i = 0 ; i < n ; i++){
            for(int y : graph[i]){
                reverseGraph.get(y).add(i) ;
            }
        }

        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(outDegree[i] == 0){
                q.offer(i) ;
            }
        }

        while(!q.isEmpty()){
            int x = q.poll() ;
            for(int y : reverseGraph.get(x)){
                outDegree[y]-- ;
                if(outDegree[y] == 0){
                    q.offer(y) ;
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>() ;
        for(int i = 0 ; i < n ; i++){
            if(outDegree[i] == 0){
                safeNodes.add(i) ;
            }
        }
        return safeNodes ;
    }
}