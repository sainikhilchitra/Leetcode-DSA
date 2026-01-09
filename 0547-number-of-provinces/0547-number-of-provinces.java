class Solution {
    void dfs(int isConnected[][],int city,int n){
        
        for(int i = 0 ; i < n; i++){
            if(isConnected[city][i] == 1){
                isConnected[city][i] = 0 ;
                dfs(isConnected,i,n) ;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;

        int connected = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    connected++ ;
                    dfs(isConnected,i,n) ;
                }
            }
        }

        return connected ;
    }
}