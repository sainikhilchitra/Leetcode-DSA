class Solution {
    void visit(int[][] isConnected,int city,boolean[] visited,int n){
        
        visited[city] = true ;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i] && isConnected[city][i] == 1){
                visit(isConnected,i,visited,n) ;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length ;
        boolean[] visited = new boolean[n] ;

        int connected = 0 ;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                connected++ ;
                visit(isConnected,i,visited,n) ;
            }
        }

        return connected ;
    }
}