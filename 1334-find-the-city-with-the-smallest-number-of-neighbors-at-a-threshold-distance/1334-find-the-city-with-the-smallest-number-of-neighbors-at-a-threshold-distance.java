class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][] = new int[n][n] ;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(graph[i],(int)1e7) ;
        }
        for(int edge[] : edges){
            graph[edge[0]][edge[1]] = edge[2] ;
            graph[edge[1]][edge[0]] = edge[2] ;
        }
        for(int i = 0 ; i < n ; i++){
            graph[i][i] = 0 ;
        }
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]) ;
                }
            }
        }
        int city = n - 1, min = n ;
        for(int i = 0 ; i < n ; i++){
            int count = 0 ;
            for(int j = 0 ; j < n ; j++){
                if(graph[i][j] <= distanceThreshold) count++ ;
            }
            if(count <= min){
                min = count ;
                city = i ;
            }
        }
        return city ;
    }
}