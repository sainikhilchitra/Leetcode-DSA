class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;

        // at max distance is n + m - 2. so to avoid integer overflow initialize with n + m
        int dist[][] = new int[n][m] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 1){
                    dist[i][j] = n + m ;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(dist[i][j] == 0) continue ;

                if(i > 0) dist[i][j] = Math.min(dist[i][j] , dist[i - 1][j] + 1) ;
                if(j > 0) dist[i][j] = Math.min(dist[i][j] , dist[i][j - 1] + 1) ;
            }
        }

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                if(dist[i][j] == 0) continue ;

                if(i < n - 1) dist[i][j] = Math.min(dist[i + 1][j] + 1, dist[i][j]) ;
                if(j < m - 1) dist[i][j] = Math.min(dist[i][j + 1] + 1, dist[i][j]) ;
            }
        }

        return dist ;
    }
}