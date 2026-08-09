class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length ;
        Queue<int[]> q = new LinkedList<>() ;
        boolean visited[][] = new boolean[n][(1 << n) + 1] ;
        for(int i = 0 ; i < n ; i++){
            q.offer(new int[]{i,(1<<i),0}) ;
            visited[i][(1 << i)] = true ;
        }
        while(!q.isEmpty()){
            int temp[] = q.poll() ;
            int x = temp[0], bitmask = temp[1], distance = temp[2] ;
            if(bitmask == (1 << n) - 1) return distance ;
            for(int y : graph[x]){
                if(visited[y][bitmask | (1 << y)]) continue ;
                visited[y][bitmask | (1 << y)] = true ;
                q.offer(new int[]{y,(bitmask | (1 << y)),distance + 1}) ;
            }
        }
        return 0 ;
    }
}